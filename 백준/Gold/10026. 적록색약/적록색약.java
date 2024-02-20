import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static char[][] map1, map2;
	static boolean[][] visited;
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map1 = new char[N][N];
		map2 = new char[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0;  j < N; j++) {
				map1[i][j] = str.charAt(j);
				char c = map1[i][j];
				
				if(c == 'R') {
					c = 'G';
				}
				map2[i][j] = c;
			}
		}
		
		int cnt1 =countGroups(map1);
		int cnt2 = countGroups(map2);
		System.out.println(cnt1+" "+cnt2);
		
	}
	private static int countGroups(char[][] map) {
		int cnt = 0;
		visited = new boolean[N][N];
		for(int i = 0;  i < N; i++) {
			for(int j = 0;  j < N; j++) {
				if(!visited[i][j]) {
					cnt++;
					bfs(i,j, map[i][j], map);
				}
			}
		}
		return cnt;
	}
	private static void bfs(int x, int y, char target, char[][] map) {
		
		
		
		Queue<Point> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new Point(x,y));
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i = 0;  i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
			
				if(nx < 0 || ny < 0 ||nx >= N || ny >= N || map[nx][ny] != target || visited[nx][ny]) {
					continue;
				}
				q.add(new Point(nx,ny));
				visited[nx][ny] = true;
			}
		}
	}

}