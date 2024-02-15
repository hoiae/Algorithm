import java.io.*;
import java.util.*;
//입력받은 좌표를 순서대로 기록함.
public class Main {
	static int[] parents;
	static int N,M;
	static double minLength;
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static class God{
		int node1;
		int node2;
		double cost;
		
		public God(int node1, int node2, double cost) {
			this.node1 = node1;
			this.node2 = node2;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			parents[i] = i;
		}
		
		
		Point[] points = new Point[N + 1];
		
		//신 위치 입력받음
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		//모든 신들의 사이의 거리를 구해서  배열을 만듬
		List<God> gods = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			for(int j = i + 1; j <= N; j++) {
				Point a = points[i];
				Point b = points[j];
				double cost = calculateDist(a,b);//두 지점 사이의 거리
				gods.add(new God(i,j,cost));
			}
		}
		
		//M개만큼 신들을 union함
		for(int i = 0;  i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		//신들사이의 거리 배열을 오름차순 정렬하여 union and find하며 cost를 더함.
		Collections.sort(gods, (o1,o2)->
			Double.compare(o1.cost, o2.cost)
		);
		
		for(int i = 0; i< gods.size(); i++) {
			God now = gods.get(i);
			if(find(now.node1) != find(now.node2)) {
				union(now.node1, now.node2);
				minLength += now.cost; 
			}
		}

		System.out.printf("%.2f",minLength);
//		System.out.println(Math.round(minLength*100)/100.0);
		
	}
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB  = find(b);
		parents[rootA] = rootB;
	}
	
	private static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	private static double calculateDist(Point a, Point b) {
		int x = a.x - b.x;
		int y = a.y - b.y;
		double result = Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
		
		return result;
	}
}