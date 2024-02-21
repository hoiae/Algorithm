import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] nextNum;
	static int N, M;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nextNum = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			nextNum[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nextNum[a].add(b);
			nextNum[b].add(a);
		}

		ans = 0;
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, 0);		
			visited[i] = false;

		}

		System.out.println(ans);
	}

	private static void dfs(int num, int cnt) {
		if(ans == 1) return;
		if (cnt == 4) {
			ans = 1;
			return;
		}

		for (int next : nextNum[num]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, cnt + 1);
				visited[next] = false;
			}
		}

	}

}