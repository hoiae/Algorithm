import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;

	static class Info implements Comparable<Info> {
		int node;
		int cost;

		public Info(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Info [node=" + node + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Info o) {
			return this.cost - o.cost;
		}

	}

	static List<Info>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 사다리
		int m = sc.nextInt(); // 뱀

		list = new ArrayList[100 + 1];
		for (int i = 0; i <= 100; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n + m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list[from].add(new Info(to, 0));
		}

		for (int i = 0; i <= 100; i++) {
			if (list[i].size() == 0) {
				for (int j = 1; j <= 6; j++) {
					if (i + j > 100)
						continue;
					list[i].add(new Info(i + j, 1));
				}
			}
		}

		dijkstra();
	}

	private static void dijkstra() {
		int[] dists = new int[100 + 1];
		Arrays.fill(dists, INF);
		dists[1] = 0;

		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(1, 0));
		while (!pq.isEmpty()) {
			Info now = pq.poll();
			if (now.cost > dists[now.node])
				continue;
			for (Info next : list[now.node]) {
				if (dists[next.node] > dists[now.node] + next.cost) {
					dists[next.node] = dists[now.node] + next.cost;
					pq.add(new Info(next.node, dists[next.node]));
				}
			}
		}

		System.out.println(dists[100]);

	}

	

}