import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		for(int i = 0; i < M; i++) {
			Arrays.fill(dp[i], -1);
		}
		int ans = dfs(0 ,0 , Integer.MAX_VALUE);
		System.out.println(ans);
	}

	private static int dfs(int x, int y, int pre) {
		//구간을 벗어난 경우 return 0
		if(x < 0 || y < 0 || x >= M || y >= N) {
			return 0;
		}
		
		//이전 값보다 높은 경우
		if(map[x][y] >= pre) {
			return 0;			
		} 
		
		//끝에 도달한 경우
		if(x == M - 1 && y == N - 1) {
			return 1;
		}
		
		//이미 기록이 있는 경우
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		
		
		int currentValue = map[x][y];
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			dp[x][y] += dfs(nx,ny,currentValue);
		}
		
		return dp[x][y];
	}

}