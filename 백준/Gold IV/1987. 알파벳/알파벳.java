import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static int max;
	static boolean[] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map= new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visited = new boolean[26];
		visited[map[0][0]-'A'] = true;
		dfs(0, 0, 1);
		System.out.println(max);

	}

	private static void dfs(int x, int y, int cnt) {
		max = Math.max(max, cnt);
	
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[map[nx][ny] - 'A']) continue;
			visited[map[nx][ny]-'A'] = true;
			dfs(nx , ny, cnt + 1);
			visited[map[nx][ny]-'A'] = false;
		}

	}

}