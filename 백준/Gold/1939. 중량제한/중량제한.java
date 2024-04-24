import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int start, end;
	static List<Point>[] map;
	static boolean[] visited;
	static int min;

	static class Point implements Comparable<Point> {
		int node;
		int cost;

		public Point(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return -1 * Integer.compare(this.node, o.node);
		}

		@Override
		public String toString() {
			return "Point [node=" + node + ", cost=" + cost + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		init();
		int lo = 0;
		int hi = 1_000_000_000 + 1;
		
		// 길이가 최대 -> 즉, upbound를 구한다.
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (bfs(mid)) {
				// 길이를 늘린다.
				lo = mid + 1;
			} else {
				// 길이를 줄인다.

				hi = mid;
			}

		}
		System.out.println(hi - 1);
	}

	private static boolean bfs(int limit) {
		visited = new boolean[n + 1];

		visited[start] = true;
		// bfs를 진행하며 가중치가 limit보다 큰 경우 false;
		Queue<Integer> q = new LinkedList<>();
		// 시작지점의 모든 값을 시작값으로 넣음.
		q.add(start);

		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == end) {
				return true;
			}

			for (Point next : map[now]) {
				if (next.cost < limit || visited[next.node]) {
					continue;
				}
				visited[next.node] = true;
				q.add(next.node);
			}
		}
		return false;
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		// 노드 입력받음
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[a].add(new Point(b, cost));
			map[b].add(new Point(a, cost));
		}

		// 출발지 도착지
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			Collections.sort(map[i]);
		}

		min = Integer.MIN_VALUE;
	}
}