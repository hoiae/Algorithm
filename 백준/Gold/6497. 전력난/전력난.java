import java.util.*;
import java.io.*;

public class Main {

	static int M, N;// 도시 수, 길 수
	static int[] parents;
	static Info[] infos;
	static int totalDist;
	static int minDist;

	static class Info {
		int node1;
		int node2;
		int dist;

		public Info(int node1, int node2, int dist) {
			this.node1 = node1;
			this.node2 = node2;
			this.dist = dist;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			if (M == 0 && N == 0)
				break;

			parents = new int[M];

			// parents 초기화
			for (int i = 0; i < M; i++) {
				parents[i] = i;
			}

			totalDist = 0;
			infos = new Info[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				infos[i] = new Info(n1, n2, dist);
				totalDist += dist;
			}
			Arrays.sort(infos, (i1, i2) -> Integer.compare(i1.dist, i2.dist));
			solve();

			sb.append(totalDist - minDist).append("\n");
		}

		System.out.println(sb);

	}

	private static void solve() {
		minDist = 0;
		for (int i = 0; i < N; i++) {
			Info info = infos[i];
			int a = info.node1;
			int b = info.node2;
			int dist = info.dist;
			if (find(a) != find(b)) {
				union(a, b);
				minDist += dist;
			}
		}
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA != rootB) {
			parents[rootA] = rootB;
		}
	}

	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

}