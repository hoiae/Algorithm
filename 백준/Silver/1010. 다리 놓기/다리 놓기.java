import java.io.*;
import java.util.*;
public class Main {

	static BufferedReader br;
	static int N,M;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			sb.append(solve()).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int solve() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[M+1][M+1];
		
		dp[0][0] = 1;
		for(int i = 1; i <= M; i++) {
			dp[i][0] = 1;
			for(int j = 1; j <= i; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		
		return dp[M][N];
	}

}