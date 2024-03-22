import java.io.*;
import java.util.*;


public class Main {
	static char[][] map;
	static int row; // ?가있는 row
	static int col; // dfs를 진행하며 대상이 될 col
	static int K, N;
	static ArrayList<Integer> top;
	static ArrayList<Integer> bottom;
	static char[] arr;
	static boolean flag;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());//알파벳 수(가로)
		N = Integer.parseInt(br.readLine());//세로

		// 정답을 숫자로 변환해서 저장함. -'A'를 통해서
		top = new ArrayList<>();
		bottom = new ArrayList<>();
		String input = br.readLine();
		for (int i = 0; i < K; i++) {
			top.add(i);
			bottom.add(input.charAt(i) - 'A');
		}

		map = new char[N][K - 1];
		for (int i = 0; i < N; i++) {
			input = br.readLine();
			for (int j = 0; j < K - 1; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		solve();
		if(!flag) {
			for(int i = 0; i < K - 1; i++) {
				sb.append("x");
			}
		}
		
		System.out.println(sb);
		
	}

	private static void solve() {
		// up을 ?위까지 내림
		loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < K - 1; j++) {
				if (map[i][j] == '?') {
					break loop;
				}
				if (map[i][j] == '-') {
					swap(top, j, j + 1);
				}
			}
		}
		// down을 ?아래까지 올림
		loop: for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < K - 1; j++) {
				if (map[i][j] == '?') {
					break loop;
				}
				if (map[i][j] == '-') {
					swap(bottom, j, j + 1);
				}
			}
		}
		
		
		// 비교함
		arr = new char[K - 1];
		flag = false;
		dfs(0);
	}

	private static void dfs(int index) {
		if (flag)
			return;
		if (index == K - 1) {
			if (check()) {
				flag = true;
				for(int i = 0; i < arr.length; i++) {
					sb.append(arr[i]);
				}
			}
			return;
		}

		// * 빈칸
		arr[index] = '*';
		dfs(index + 1);
		// - 막대기
		if (index == 0 || arr[index-1] != '-') {
			arr[index] = '-';
			dfs(index + 1);
		}
	}

	private static boolean check() {
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i = 0; i < K ; i++) {
			int value = top.get(i);
			temp.add(value);
		}
		
		for (int i = 0; i < K - 1; i++) {
			if (arr[i] == '-') {
				swap(temp, i, i + 1);
			}
		}

		for (int i = 0; i < K - 1; i++) {
			if (temp.get(i) != bottom.get(i)) {
				return false;
			}
		}
		return true;
	}

	private static void swap(ArrayList<Integer> list, int i, int j) {
		int stock = list.get(i);
		list.set(i, list.get(j));
		list.set(j, stock);
	}

}