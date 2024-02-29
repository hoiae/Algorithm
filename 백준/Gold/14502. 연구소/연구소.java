import java.io.*;
import java.util.*;

public class Main {

	/**
	 * 8 * 8 중에 3개를 고르는 방법? 50 * 64
	 * 
	 * 1. 빈칸의 좌표로 3개를 뽑는 조합. 8 7 6 / 6 = 56 2. 좌표를 막는다. 3. bfs를 한다. 56 * 64 4. 방문처리용
	 * 배열visited와 map[][]을 사용해서 0의 개수를 센다.56 * 64 * 2 5. 0의 개수를 min에 계속 최신화한다.
	 * 
	 */
	static int N, M;
	static boolean[][] visited;
	static int[][] map;
	static int safe;
	static List<Point> zeros;
	static List<Point> virus;
	static int cnt;// virus;
	static int min;

	static class Point {
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

		map = new int[N][M];
		zeros = new ArrayList<>();
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zeros.add(new Point(i, j));
				}
				if (map[i][j] == 2) {
					virus.add(new Point(i, j));
				}
			}
		}

		min = Integer.MAX_VALUE;
		// 3중포문으로 0인 칸중 3개를 1로 막음
		for (int i = 0; i < zeros.size(); i++) {
			map[zeros.get(i).x][zeros.get(i).y] = 1;
			for (int j = i + 1; j < zeros.size(); j++) {
				map[zeros.get(j).x][zeros.get(j).y] = 1;
				for (int k = j + 1; k < zeros.size(); k++) {
					map[zeros.get(k).x][zeros.get(k).y] = 1;
					solve();
					map[zeros.get(k).x][zeros.get(k).y] = 0;
				}
				map[zeros.get(j).x][zeros.get(j).y] = 0;
			}
			map[zeros.get(i).x][zeros.get(i).y] = 0;
		}

		System.out.println(zeros.size() - min - 3);
	}

	private static void solve() {
		visited = new boolean[N][M];
		// 전이되는 바이러스의 개수를 셈. -> zeros.size()에서 값을 제외한 값을 최신화함.max에
		cnt = 0;
		for (Point start : virus) {
			bfs(start);
		}

		min = Math.min(min, cnt);
		
	}

	private static void bfs(Point start) {
		if (visited[start.x][start.y])
			return;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(start.x, start.y));
//		visited[start.x][start.y] = true;

//		for(int i = 0;  i < N; i++) {
//			for(int j = 0;  j < M; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0 || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				cnt++;// 확산된 공간 카운팅
				q.add(new Point(nx, ny));
			}
		}
	}

}