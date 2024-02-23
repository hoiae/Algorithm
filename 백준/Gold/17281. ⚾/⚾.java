import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] visited;
	static int scores[][];
	static int maxScore;// 각 이닝별 최고점수
	static int inning;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		// 이닝별, 타자의 점수를 받음
		scores = new int[N][9];
		for (int i = 0; i < N; i++) {
			scores[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		visited = new boolean[9];
		arr = new int[9];
		// 각 이닝별 최대 점수를 계산하여 더한다.
		solve();
	
		
		System.out.println(maxScore);
	}

	private static void solve() {
		
		//순열을 만듬
		permutation(0);
		
		
	}

	private static void permutation(int depth) {
		if(depth == 9) {
			//경기 진행
			int score = play();
			maxScore = Math.max(maxScore,score);
			return;
		}
		if(depth == 3) depth++;
		
		for(int i = 1; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}

	private static int play() {
		inning = 0;
		int score = 0;
		int index = 0;
		for(int inning = 0; inning < N; inning++) {
			int out = 0;//out이 3이 되면 종료해야함.
			int inningScore = 0;
			Queue<Integer> field = new LinkedList<>();
			//타자가 점수를 내는 경우 필드를 순회하면서 값을 더함.
			//더한 값이 4 이상이면 그냥 바로 점수화 이후 제거함.
			while(true) {
				if(out == 3) {
					field.clear();
					score += inningScore;
					break;
				}
				int command = scores[inning][arr[index]];
				if(command == 0) { //아웃인 경우
					out++;
				}else { //진루 
					int size = field.size();
					
					for(int j = 0; j < size; j++) {
						int now = field.poll();
						now += command;
						if(now > 3) {
							inningScore++; //점수를 내고 필드를 벗어남.
						}else {
							field.add(now); //필드에 남아있음
						}
					}
					
					if(command == 4) {//홈런인 경우 
						inningScore++;
					}else {
						field.add(command); //필드에 점수를 넣음					
					}
				}
				index++;
				if(index == 9) index = 0;
			}
		}
		
		return score;
	}
}