
import java.util.*;
import java.io.*;

public class Main {
	static int white;
	static int blue;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, n);
		System.out.println(white);
		System.out.println(blue);

	}

	private static void dfs(int r, int c, int len) {
		if (len == 1) {
			if(map[r][c]==1) {
				blue++;
			}else {
				white++;
			}
			return;
		}
		// 범위검사
		if(checkIsSquare(r,c,len)) {
			return;
		}
		int half = len / 2;
		// 쪼개기
		dfs(r, c, half);
		dfs(r, c + half, half);
		dfs(r + half, c, half);
		dfs(r + half, c + half, half);

	}

	private static boolean checkIsSquare(int r, int c, int len) {
		int startColor = map[r][c];
		for(int i = r; i < r + len; i++) {
			for(int j = c; j < c + len; j++) {
				if(map[i][j] != startColor) {
					return false;
				}
			}
		}
		if(startColor == 1) {
			blue++;
		}else {
			white++;
		}
		return true;
	}

}
