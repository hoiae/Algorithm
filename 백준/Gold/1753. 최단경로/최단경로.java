import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static List<Info>[] map;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;
	static class Info implements Comparable<Info> {
		int node;
		int cost;

		public Info(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());

		dist = new int[V+1];
		map = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i = 0;  i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost  = Integer.parseInt(st.nextToken());
			map[from].add(new Info(to,cost));
		}
		
		dijkstra(start);
		StringBuilder sb = new StringBuilder();
		for(int i = 1;  i<=V; i++) {
			if(dist[i] == INF) {
				sb.append("INF");
			}else {
				sb.append(dist[i]);				
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start,0));
		
		while(!pq.isEmpty()) {
			Info now = pq.poll();
			if(now.cost > dist[now.node]) continue;
			
			for(Info next : map[now.node]) {
				if(dist[next.node] > now.cost + next.cost) {
					dist[next.node] = now.cost + next.cost;
					pq.add(new Info(next.node, dist[next.node]));
				}
			}
		}
	}

}