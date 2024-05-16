import java.io.*;
import java.util.*;

public class Main {
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] map = new int[100][100];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;

			int size = Math.abs(x1 - x2) * Math.abs(y1 - y2);

			for (int dx = x1; dx <= x2; dx++) {
				for (int dy = y1; dy <= y2; dy++) {
					map[dx][dy] += 1;
				}
			}

		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] > m)
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}