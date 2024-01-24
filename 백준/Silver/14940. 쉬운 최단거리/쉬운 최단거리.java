
import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14940
public class Main {
	static int[][] map;
	static int N, M;
	static boolean[][] visited;

	static class Point {
		int r;
		int c;
		int dist;

		public Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		// map입력, 시작지점저장
		map = new int[N][M];
		Point destination = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					destination = new Point(i, j, 0);
				}
			}
		}

		findShortestWay(destination);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					map[i][j] = -1;
				}
				System.out.print(map[i][j] + " ");

			}
			System.out.println();
		}
	}

	private static void findShortestWay(Point startPoint) {
		map[startPoint.r][startPoint.c] = 0;
		visited[startPoint.r][startPoint.c] = true;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(startPoint.r, startPoint.c, 0));

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.r + dx[i];
				int ny = now.c + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					map[nx][ny] = now.dist + 1;
					q.add(new Point(nx, ny, now.dist + 1));
				}
			}
		}
	}
}
