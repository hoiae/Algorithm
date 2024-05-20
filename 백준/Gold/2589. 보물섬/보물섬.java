import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				if (input.charAt(j) == 'L') {
					map[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}

		System.out.println(max);

	}

	private static void bfs(int sx, int sy) {
//		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
//			return Integer.compare(o1[2], o2[2]);
//		});
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sx, sy, 0 });
		visited = new boolean[n][m];
		visited[sx][sy] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int dist = now[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}
				visited[nx][ny] = true;
				q.add(new int[] { nx, ny, dist + 1 });
				max = Math.max(max, dist + 1);
			}

		}

	}

}