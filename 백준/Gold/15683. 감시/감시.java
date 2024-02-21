import java.io.*;
import java.util.*;

public class Main {

	static int map[][];
	static int N, M;
	static boolean isShow[][];
	static ArrayList<Point> cctvs;
	static int[] dirs;
	static int min = Integer.MAX_VALUE;
	// 상 우 하 좌
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Point {
		int type;
		int x;
		int y;

		public Point(int type, int x, int y) {
			this.type = type;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		// 0 빈캇, 6 벽, 1~5cctv
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cctvs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvs.add(new Point(map[i][j], i, j));
				}
			}
		}

		dirs = new int[cctvs.size()];
		solve();

	}

	private static void solve() {
		directionPermutation(0);
		System.out.println(min);
	}

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(isShow[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void directionPermutation(int depth) {
		if (depth == cctvs.size()) {
			// TODO 경우의 수대로 cctv를 위치시킨 후 카운팅
			calculate();
			return;
		}

		for (int i = 0; i < 4; i++) {
			dirs[depth] = i;
			directionPermutation(depth + 1);
		}
	}

	private static void calculate() {
		isShow = new boolean[N][M];
		// cctv를 배치함
		for (int i = 0; i < cctvs.size(); i++) {
			Point cctv = cctvs.get(i);
			if (cctv.type == 1) {
				func1(cctv.x, cctv.y, dirs[i]);
			} else if (cctv.type == 2) {
				func2(cctv.x, cctv.y, dirs[i]);
			} else if (cctv.type == 3) {
				func3(cctv.x, cctv.y, dirs[i]);
			} else if (cctv.type == 4) {
				func4(cctv.x, cctv.y, dirs[i]);
			} else { // 5인 경우
				func5(cctv.x, cctv.y, dirs[i]);
			}
		}
		
		// 볼수 없는 공간 카운트
		int invisible = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!isShow[i][j] && map[i][j] != 6) {
					invisible++;
				}
			}
		}
		min = Math.min(min, invisible);

	}

	private static void move(int x, int y, int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		//TODO
		isShow[x][y] = true;

		while (nx >= 0 && nx < N && ny >= 0 && ny < M 
				&& map[nx][ny] != 6) {
			isShow[nx][ny] = true;
			nx = nx + dx[dir];
			ny = ny + dy[dir];
		}
	}

	// 1~5번CCTV
	// 상 하 좌 우
	// 1번은 기본 오른쪽 = 1
	private static void func1(int x, int y, int rotate) {
		int dir = (1 + rotate) % 4;

		move(x, y, dir);
	}

	private static void func2(int x, int y, int rotate) {
		// 오른쪽 기본 방향
		int dir1 = (1 + rotate) % 4;
		move(x, y, dir1);

		// 왼쪽 기본 방향
		int dir2 = (3 + rotate) % 4;
		move(x, y, dir2);
	}

	private static void func3(int x, int y, int rotate) {
		// 오른쪽 기본 방향
		int dir1 = (1 + rotate) % 4;
		move(x, y, dir1);

		// 위쪽 기본 방향
		int dir2 = (0 + rotate) % 4;
		move(x, y, dir2);
	}

	private static void func4(int x, int y, int rotate) {
		// 오른쪽 기본 방향
		int dir1 = (1 + rotate) % 4;
		move(x, y, dir1);

		// 위쪽 기본 방향
		int dir2 = (0 + rotate) % 4;
		move(x, y, dir2);

		// 왼쪽 기본 방향
		int dir3 = (3 + rotate) % 4;
		move(x, y, dir3);
	}

	private static void func5(int x, int y, int rotate) {
		// 오른쪽 기본 방향
		int dir1 = (1 + rotate) % 4;
		move(x, y, dir1);

		// 위쪽 기본 방향
		int dir2 = (0 + rotate) % 4;
		move(x, y, dir2);

		// 왼쪽 기본 방향
		int dir3 = (3 + rotate) % 4;
		move(x, y, dir3);

		// 아래쪽 기본 방향
		int dir4 = (2 + rotate) % 4;
		move(x, y, dir4);

	}

}