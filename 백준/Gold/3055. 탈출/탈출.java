import java.io.*;
import java.util.*;

public class Main {

	// 물*, 돌X, 비버굴D, 고슴도치S

	// 물, 고슴도치는 돌을 통과할 수 없다.
	// 고슴도치는 물을 이동할 수 없다.
	// 물은 비버의 소굴로 이동할 수 없다.

	/* 고슴 도치는 물이 찰 에정인 칸으로 이동할 수 없다?! */
	static int R, C;
	static char[][] map;
	static Queue<Point> waterq;
	static Queue<Point> goq;
	static int cnt;

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

		waterq = new LinkedList<>();
		goq = new LinkedList<>();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);

				if (map[i][j] == '*') {
					waterq.add(new Point(i, j));
				}

				if (map[i][j] == 'S') {
					goq.add(new Point(i, j));
				}
			}
		}

		if (solve()) {
			System.out.println(cnt);
		} else {
			System.out.println("KAKTUS");
		}

		// 물 이동 -> map에 반영
		// 고슴도치 이동 -> map에 반영
	}

	private static boolean solve() {

		boolean[][] visited = new boolean[R][C];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		while (!goq.isEmpty()) {
			cnt++;
			// 물 이동
			int wcnt = waterq.size();

			// TODO 횟수 수정
			while (wcnt > 0) {
				Point now = waterq.poll();
				wcnt--;
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '*' || map[nx][ny] == 'D'
							|| map[nx][ny] == 'X')
						continue;
					map[nx][ny] = '*';
					waterq.add(new Point(nx, ny));
				}
			}

			int gcnt = goq.size();
			// 고슴 도치 이동
			while (gcnt > 0) {
				Point now = goq.poll();
				gcnt--;
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '*' || map[nx][ny] == 'X'
							|| visited[nx][ny])
						continue;
					if (map[nx][ny] == 'D')
						return true;
					goq.add(new Point(nx, ny));
					visited[nx][ny] = true;

				}
			}
		}

		return false;

	}

}