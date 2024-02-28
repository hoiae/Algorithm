
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][][] dp;
	static final int HORIZONTAL = 0; // -> HORIZONTAL . DIAGONAL
	static final int VERTICAL = 1; // -> VERTICAL, DIAGONAL
	static final int DIAGONAL = 2;// -> HORIZONTAL, VERTICAL, DIAGONAL
	static class Point{
		int x;
		int y;
		int dir;
		
		public Point(int x, int y , int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0;  i < N; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[17][17][3];
		for(int i = 0;  i < 17 ; i ++) {
			for(int j = 0;  j < 17; j++) {
				Arrays.fill(dp[i][j],-1);
			}
		}
		int ans = dfs(0,1,HORIZONTAL);
		
		System.out.println(ans);
	}
	private static int dfs(int x, int y, int dir) {
		if(dp[x][y][dir] != -1) {
			return dp[x][y][dir];
		}
		
		//맵을 벗어난 경우
		if(x >= N || y >= N) {
			return 0;
		}
		//현 위치가 벽인경우
		if(map[x][y] == 1) {
			return dp[x][y][dir] = 0;
		}
		//대각선인 경우, 진행이 불가능한 경우
		if(dir == DIAGONAL) {
			if(map[x - 1][y] == 1 || map[x][y - 1] == 1) {
				return dp[x][y][dir] = 0;
				
			}
		}
		/*도착한 경우*/
		if(x == N - 1 && y == N - 1) {
			return 1;
		}
		
		//가로
		if(dir == HORIZONTAL) {
			dp[x][y+1][HORIZONTAL] = dfs(x, y + 1,HORIZONTAL);//가로방향  
			dp[x+1][y+1][DIAGONAL] = dfs(x + 1, y + 1, DIAGONAL);//대각선방향
			return dp[x][y][dir] = dp[x][y+1][HORIZONTAL] +dp[x+1][y+1][DIAGONAL];
		}
		
		//세로
		else if(dir == VERTICAL) {
			dp[x+1][y][VERTICAL] = dfs(x + 1, y, VERTICAL);//세로방향
			dp[x+1][y+1][DIAGONAL] = dfs(x + 1, y + 1, DIAGONAL);//대각선 방향
			return dp[x][y][dir] = dp[x+1][y][VERTICAL] + dp[x+1][y+1][DIAGONAL];
		}
		
		//대각선
		else {
			dp[x][y+1][HORIZONTAL] = dfs(x, y + 1,HORIZONTAL);//가로방향 
			dp[x + 1][y][VERTICAL]= dfs(x + 1, y, VERTICAL);//세로방향
			dp[x + 1][y + 1][DIAGONAL]= dfs(x + 1, y + 1, DIAGONAL);//대각선 방향
			return dp[x][y+1][HORIZONTAL] + dp[x + 1][y][VERTICAL] + dp[x + 1][y + 1][DIAGONAL];
		}
	}	
}
