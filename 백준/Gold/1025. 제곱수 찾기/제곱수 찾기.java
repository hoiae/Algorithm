import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] map;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		max = -1;
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				solve(i, j);
			}
		}

		System.out.println(max);

	}

	private static void solve(int startX, int startY) {
		for (int i = -n; i < n; i++) {
			for (int j = -m; j < m; j++) {
				if (i == 0 && j == 0)
					continue;

				int num = 0;

				int x = startX;
				int y = startY;
			

				while (x >= 0 && y >= 0 && x < n && y < m) {
					num *= 10;
					num += map[x][y];
					if ((int)(Math.pow((int)Math.sqrt(num), 2)) == num) {
						max = Math.max(max, num);
					}
					x += i;
					y += j;
				}

			}
		}

	}

}