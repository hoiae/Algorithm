import java.io.*;
import java.util.*;
public class Main {
	static int m,n;
	static int[] shoot;
	static Point[] animal;
	static long l;
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());//사대수
		n = Integer.parseInt(st.nextToken());//동물수
		l = Integer.parseInt(st.nextToken());//사정거리
		
		shoot = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i  = 0; i< m; i++) {
			shoot[i] = Integer.parseInt(st.nextToken());
		}
		
		animal = new Point[n];
		for(int i = 0; i < n; i++) {
			st =new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			animal[i] = new Point(x,y);
		}
		
		Arrays.sort(shoot);
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			int lo = 0;
			int hi = m - 1;
			while(lo <= hi) {
				int mid = (lo + hi) / 2;
				int dist = Math.abs(animal[i].x - shoot[mid]) + animal[i].y;

				if(dist <= l) {
					cnt++;
					break;					
				}
				
				if(animal[i].x < shoot[mid]) {
					hi = mid - 1;
				}else {
					lo = mid + 1;
				}
				
			}
		}
		System.out.println(cnt);
	}
}