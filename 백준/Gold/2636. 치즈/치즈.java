import java.io.*;
import java.util.*;

public class Main {
	static int time;
	static int cheeses;
	static int[][] map;
	static int N, M;
	static int cnt;
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
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		// 입력받을때 치즈의 총 개수 total을 파악해놓는다.
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cheeses++;
				}
			}
		}
		
		for(int i = 0;  i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i == 0 || i == N - 1 || j == 0 || j ==  M - 1) {
					if(visited[i][j]) continue;
					bfs(i,j);
				}
			}
		}
		
		time = 1;
		
		while(cheeses > 0) {
			cnt = 0;
			visited = new boolean[N][M];
			time++;
			bfs(1,1);
		}
		
		System.out.println(time+"\n"+cnt);
		// 바깥쪽좌표에서 bfs시작
		// visit이 false인 치즈를 만나면
		// 해당 좌표를 0으로 변경함.
		// cnt++;
		// 치즈의 개수(cheese --)

		// (1,1)에서 bfs시작
		// time++
		// 만나는 치즈를 모두 0로 변경함.
		// cnt++;
		// if(cheeses -= cnt == 0)이면 종료
		// cheese -= 실행(종료되지 않은 경우에만)

	}

	private static void bfs(int startX, int startY) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(startX,startY));
		visited[startX][startY] = true;
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
				
				//다음 위치가, 치즈인 경우 => 탐색 종료, map = 0//, 치즈가 아닌경우 좌표탐색
				if(map[nx][ny] == 1) {
					map[nx][ny] = 0;
					cnt++;
					cheeses--;
				}else {
					q.add(new Point(nx,ny));
				}
				visited[nx][ny] = true;
			}
		}
	}

}