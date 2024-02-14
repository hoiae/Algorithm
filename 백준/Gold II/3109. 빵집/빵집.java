import java.io.*;
import java.util.*;

/*
 * 1열의 상단부터 하단까지  dfs를 진행
 *  - 각좌표에서는 우측 상단, 우측, 우측하단순서로 진행
 *  - 마지막 열에 도달하면 종료
 *  	- 종료와 동시에 그동안 거쳐온 구간을 전부 방문처리 해야함.*
 *  	- */
public class Main {
	static int R, C;
	static boolean[][] map;
	static int cnt;
	static boolean isEnd;

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				if (input.charAt(j) == '.') {
					map[i][j] = false;
				} else {
					map[i][j] = true;
				}
			}
		}

		solve();
	}

	private static void solve() {
		// 첫번째열에서, 첫번째 행 ~ 마지막 열까지 dfs진행
		for (int i = 0; i < R; i++) {
			isEnd = false;
			map[i][0] = true;
			findWay(i, 0, 1);
		}
		System.out.println(cnt);
	}

	private static void findWay(int r, int c, int depth) {
		if (depth == C) {
			isEnd = true;
			cnt++;
			isEnd= true;
			return;
		}
		
		
		map[r][c] = true;
		// 상 -> 우 -> 하
		if (!isEnd && r - 1 >= 0  && !map[r - 1][c + 1]) {
			findWay(r - 1, c + 1, depth + 1);
		}
		if (!isEnd  && !map[r][c + 1]) {
			findWay(r, c + 1, depth + 1);

		} 
		if (!isEnd && r + 1 < R && !map[r + 1][c + 1]) {
			findWay(r + 1, c + 1, depth + 1);
		}
	}

}