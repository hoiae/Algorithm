import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static int n = 9;
	static boolean[][] row;
	static boolean[][] col;
	static List<Point> points;
	static boolean[][][] board;
	static boolean flag;

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

		points = new ArrayList<>();
		map = new int[n][n];
		// 가로줄의 숫자확인용 배열
		row = new boolean[n][n + 1];// 행, 숫자포함여부
		col = new boolean[n][n + 1];// 열, ``
		// board는 3*3의 숫자들을 확인함
		board = new boolean[3][3][n + 1];

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				row[i][map[i][j]] = true;// 방문배열에 표기함.
				col[j][map[i][j]] = true;
				board[i / 3][j / 3][map[i][j]] = true;// 3*3배열 방문 표기함.
				if (map[i][j] == 0) {
					points.add(new Point(i, j));
				}
			}
		}
		// points에 접근할 인덱스
		dfs(0);
		// 0인경우 1~9중 하나를 채움,
		// 모든 채우기가 완성되면 구간을 3*3으로 쪼개어 판단한다.

	}

	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int index) {
		// TODO 3 * 3검사 로직, 조건을 만족하는 경우 종료
		if (flag)
			return;
		if (index == points.size()) {
//			if(judge33()) {
			printMap();
//			System.out.println();
			flag = true;
//			}
			return;
		}

		Point now = points.get(index);

		for (int i = 1; i <= 9; i++) {
			if (row[now.x][i] || col[now.y][i] || board[now.x / 3][now.y / 3][i])
				continue;
			row[now.x][i] = true;
			col[now.y][i] = true;
			board[now.x / 3][now.y / 3][i] = true;
			
			map[now.x][now.y] = i;
			dfs(index + 1);

			row[now.x][i] = false;
			col[now.y][i] = false;
			board[now.x / 3][now.y / 3][i] = false;
		}

	}

	private static boolean judge33() {
		for (int r = 0; r < 9; r += 3) {
			for (int c = 0; c < 9; c += 3) {

				// 3*3배열 탐색
				boolean[] board = new boolean[9 + 1];

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (board[map[r + i][c + j]]) {
							return false;
						}
						board[map[r + i][c + j]] = true;
					}
				}
			}
		}

		return true;
	}

}