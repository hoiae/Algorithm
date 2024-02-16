import java.io.*;
import java.util.*;

public class Main {
	static int N, M, V;
	static ArrayList<Integer>[] map;
	static StringBuilder sb;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		map = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a].add(b);
			map[b].add(a);
		}

		for (List<Integer> l : map) {
			Collections.sort(l);
		}

		sb = new StringBuilder();
		visited = new boolean[N + 1];
		visited[V] = true;
		dfs(V);
		sb.append("\n");

		visited = new boolean[N + 1];
		visited[V] = true;
		bfs(V);

		System.out.println(sb);
	}

	private static void bfs(int start) {

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now + " ");
			for (int next : map[now]) {
				if (visited[next])
					continue;
				visited[next] = true;
				q.add(next);
			}
		}
	}

	private static void dfs(int node) {
		sb.append(node + " ");
		for (int next : map[node]) {
			if (visited[next])
				continue;
			visited[next] = true;
			dfs(next);
		}
	}

}