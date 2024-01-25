
import java.util.*;
import java.io.*;
public class Main {
	static int M,N,H;
	static int lastDay;
	static int greenCnt;
	static int greenToRedCnt;
	static boolean[][][] visited;
	static int[][][] map;
	static Queue<Point> q = new LinkedList<>();
	static class Point{
		int h;
		int n;
		int m;
		int day;
		public Point(int h,int n,int m, int day) {
			this.m = m;
			this.n = n;
			this.h = h;
			this.day = day;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		visited = new boolean[H][N][M];
		for(int h = 0;  h < H; h++) {
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if(map[h][i][j] == 0) {//안익은 토마토의 개수를 셈
						greenCnt++;
					}
					if(map[h][i][j] == 1) {//익은 토마토를 큐에 넣음
						q.add(new Point(h,i,j,0));
					}
				}
			}
		}
		
		solve();
		
		int ans = 0;
		if(greenCnt == 0) {
			ans = 0;
		}else if(greenCnt != greenToRedCnt) {
			ans = -1;
		}else {
			ans = lastDay;
		}
		
		System.out.println(ans);
		
	}
	
	
	private static void solve() {
		
		int[] dn = {-1,1,0,0};
		int[] dm = {0,0,-1,1};
		int[] dh = {1,-1};
		while(!q.isEmpty()) {
			Point now = q.poll();
			int curM = now.m;
			int curN = now.n;
			int curH = now.h;
			int curDay = now.day;
			lastDay = Math.max(lastDay, curDay);
			//같은층 
			for(int i = 0;  i < 4; i++) {
				int nN = curN + dn[i];
				int nM = curM + dm[i];
				if(nM < 0 || nN < 0 || nM >= M || nN >= N) continue;
				//처음 방문하는 경우와
				if(!visited[curH][nN][nM] && map[curH][nN][nM] == 0) {
					visited[curH][nN][nM] = true;
					q.add(new Point(curH, nN, nM ,curDay + 1));
					greenToRedCnt++;
				}
			}
			//위아래층
			for(int i = 0; i < 2; i++) {
				int nH = curH + dh[i];
				if(nH < 0 || nH >= H) continue;
				if(!visited[nH][curN][curM] && map[nH][curN][curM] == 0) {
					visited[nH][curN][curM] = true;
					q.add(new Point( nH, curN, curM, curDay + 1));
					greenToRedCnt++;
				}
			}
			
		}
		
	}

}
