import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static int INF = Integer.MAX_VALUE;
	static List<Info>[] map;
	static class Info implements Comparable<Info>{
		int node;
		int dist;
		public Info(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			solve();
		}
		System.out.println(sb);
	}
	private static void solve() throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //컴퓨터 개수
		int d = Integer.parseInt(st.nextToken()); //의존성 개수
		int c = Integer.parseInt(st.nextToken()); //해킹당한 컴퓨터 번호
		
		map = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		
		int[] dists = new int[n + 1];
		Arrays.fill(dists, INF);
		dists[c] = 0;
		for(int i = 0; i < d; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());//시간초
			map[b].add(new Info(a,s));
		}
		
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(c,0));
		
		while(!pq.isEmpty()) {
			Info now = pq.poll();
			for(Info next : map[now.node]) {
				if(dists[next.node] > next.dist + dists[now.node]) {
					dists[next.node] = next.dist + dists[now.node];
					pq.add(new Info(next.node, dists[next.node]));
					
				}
			}
		}
		
		int cnt = 0;
		int time = 0;
		for(int i = 1; i <= n; i++) {
			if(dists[i] != INF) {
				cnt++;
				time = Math.max(time,dists[i]);
			}
		}
		
		
		sb.append(cnt+" "+time+"\n");
	}
}