import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N,M;
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int cnt;
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M ];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0;  j< M; j++) {
				
				map[i][j] = str.charAt(j) - '0';
			}
		}
		visited = new boolean[N][M];
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.add(new Point(0,0,0));
		visited[0][0] = true;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int ans = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.x == N - 1 && now.y == M-1) {
				ans = Math.min(ans, now.cnt);
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				
				if(nx < 0|| ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
					continue;
				}
				
				int nextCnt = now.cnt;
				if(map[nx][ny] == 1) {
					nextCnt++;
				}
				visited[nx][ny] = true;
				q.add(new Point(nx,ny,nextCnt));
			}
		}
		System.out.println(ans);
		
	}

}