import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static int[][] map;
	static int N;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		//n입력
		//map입력
		//로직
		StringBuilder sb = new StringBuilder();
		int index = 1;
		while((N = Integer.parseInt(br.readLine())) != 0) {
			//map입력
			map = new int[N][N];
			visited= new boolean[N][N];
			for(int i = 0; i < N; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			sb.append("Problem "+index+": "+solve()+"\n");
			index++;
		}
		
		System.out.println(sb);
		
	}
	private static int solve() {
		//우선순위큐?
		//x,y,cnt
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
		pq.add(new int[] {0, 0, map[0][0]});
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		visited[0][0] = true;
		int value = 0;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(now[0] == N-1 && now[1] == N - 1) {
				value = now[2];
			}
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
					continue;
				visited[nx][ny] = true;
				pq.add(new int[] {nx, ny, now[2] + map[nx][ny]});
			}
		}
		return value;
	}

}