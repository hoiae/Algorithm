import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static char map[][];
	static int startX,startY;
	static boolean[][][] visited;
	static class Info implements Comparable<Info>{
		int x;
		int y;
		int visit;
		int cnt;
		
		public Info(int x, int y, int visit, int cnt) {
			this.x = x;
			this.y = y;
			this.visit = visit;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Info o) {
			return this.cnt - o.cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map= new char[N][M];
		for(int i = 0; i< N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == '0') {
					startX = i;
					startY = j;
				}
			}
		}
		int size = 1 << 6;
		visited = new boolean[N][M][size];
		int ans = bfs();
		System.out.println(ans);
	}
	private static int bfs() {		
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(startX,startY,0,0));
		visited[startX][startY][0] = true;
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		while(!pq.isEmpty()) {
			Info now = pq.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '#' || visited[nx][ny][now.visit]) {
					continue;
				}
				
				
				//다음칸이 벽인 경우
				if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
					if((now.visit & (1 << (map[nx][ny] - 'A'))) == 0) {
						continue;
					}
				}
				
				//키인 경우
				int nextVisit = now.visit;
				if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
					nextVisit |= (1 <<(map[nx][ny] -'a')); 
				}
				
				if(map[nx][ny] == '1') {
					return now.cnt + 1;
				}
				
				visited[nx][ny][now.visit] = true;
				pq.add(new Info(nx, ny, nextVisit, now.cnt + 1));
				
				
			}
			
		}
		return -1;
	}

}