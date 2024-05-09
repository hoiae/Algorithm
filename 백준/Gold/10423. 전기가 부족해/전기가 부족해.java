import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;// 도시의 개수, 케이블의 수, 발전소의 개수
	static Set<Integer> powers;
	static int[] parents;
	static int[][] edges;
	static int total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 도시의 개수
		M = Integer.parseInt(st.nextToken());// 케이블의 수
		K = Integer.parseInt(st.nextToken());// 발전소의 개수

		powers = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			powers.add(Integer.parseInt(st.nextToken()));
		}

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		edges = new int[M][3]; // 도시1,도시2,비용
		// 간선정보 입력받음
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[i][0] = a;
			edges[i][1] = b;
			edges[i][2] = cost;
		}
		// 가중치로 정렬
		Arrays.sort(edges, (o1, o2) -> {
			return Integer.compare(o1[2], o2[2]);
		});

		solve();
	}

	private static void solve() {
		// 가중치별로 유니온 파인드 진행함
		for (int i = 0; i < M; i++) {
			if (find(edges[i][0]) != find(edges[i][1])) {
				union(edges[i][0], edges[i][1], edges[i][2]);
			}
		}

		System.out.println(total);
	}

	private static void union(int a, int b, int cost) {
		int rootA = find(a);
		int rootB = find(b);
		if(powers.contains(rootA) && powers.contains(rootB)) {
			return;
		}
		if(powers.contains(rootA)) {
			parents[rootB] = rootA;
		} else {
			parents[rootA] = rootB;
		}
		total += cost;
	}

	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
}