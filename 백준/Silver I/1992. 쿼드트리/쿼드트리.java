import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		String ans = solve(0, 0, N);
		System.out.println(ans);
	}

	private static String solve(int x, int y, int len) {
		if (len == 1) {
			return String.valueOf(map[x][y]);
		}

		if (checkIsEnd(x, y, len)) {
			return String.valueOf(map[x][y]);
		}

		StringBuilder sb = new StringBuilder();
		// 첫번째 괄호
		sb.append("(");

		// 2사
		sb.append(solve(x, y, len / 2));
		// 1사
		sb.append(solve(x, y + len / 2, len / 2));
		// 3사
		sb.append(solve(x + len / 2, y, len / 2));
		// 4사
		sb.append(solve(x + len / 2, y + len / 2, len / 2));
		// 마지막 괄호
		sb.append(")");

		return sb.toString();
	}

	private static boolean checkIsEnd(int x, int y, int len) {
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (map[x + i][y + j] != map[x][y]) {
					return false;
				}
			}
		}
		return true;
	}

}