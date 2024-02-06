import java.util.*;
import java.io.*;
public class Main {
	static int N,M,R;
	static int[][] map;
	static int[][] cloneMap;
	static boolean[][] visited;
	static boolean[][] visited2;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int startX, startY;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		visited2 = new boolean[N][M];
		map = new int[N][M];
		for(int i = 0;  i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		solve();
		printMap();
	}
	private static void printMap() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void solve() {
		int p = 0;
		while(!visited[p][p]) {
			rotate(p,p);
			p++;
		}
		
	}
	private static void rotate(int startX, int startY) {
		cloneMap = new int[N][M];

		int nx = startX;
		int ny = startY;
		int lastDirection = 0;
		while(!visited[nx][ny]){
			//방문처리
			visited[nx][ny] = true;
			
			//값 옮기기
			cloneMap[nx][ny] = getValue(nx,ny, lastDirection);
			
			//다음 대상 좌표 이동
			for(int i = lastDirection; i <4; i++) {
				if(nx + dx[i] >= 0 && ny + dy[i] >= 0
						&& nx + dx[i] < N && ny + dy[i] < M 
						&& !visited[nx + dx[i]][ny + dy[i]]) {
					nx = nx + dx[i];
					ny = ny + dy[i];
					lastDirection = i;
					break;
				}
			}
			
		}
		
		map[startX][startY] = getValue(startX, startY, lastDirection);
		for(int i = 0;  i < N; i++) {
			for(int j = 0;  j <M; j++) {
				if(cloneMap[i][j] != 0) {
					visited2[i][j] = true;
					map[i][j] = cloneMap[i][j];
				}
			}
		}
		
		
	}
	private static int getValue(int x, int y, int dir) {
		if(dir == 3) dir = 1;
		else if(dir == 1)dir =3;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int cnt = R;
		for(int i = dir; i < 4; i = (i + 1) % 4) {
			while(x + dx[i] >= 0 && y + dy[i] >= 0
					&& x + dx[i] < N && y + dy[i] < M
					&& !visited2[x + dx[i]][y + dy[i]]) {
				cnt--;
				x = x + dx[i];
				y = y + dy[i];
				if(cnt == 0) {
					return map[x][y];
				}
			}
		}
		
		return -1;
	}

}