import java.util.*;
import java.io.*;

public class Main {
	static int N,T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		int[] times = new int[N + 1];
		int[] values = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[T+1][N+1]; //시간, N
		//가로축: 사용가능한 시간
		for(int i = 1; i <= T; i++) {
			for(int j = 1; j <= N; j++) {
				if(times[j] > i) {
					dp[i][j] = dp[i][j - 1];
				}else {
					dp[i][j] = Math.max(dp[i][j - 1], values[j]
							+ dp[i - times[j]][j - 1]);
				}
			}
		}
		
		System.out.println(dp[T][N]);
		
		
	}

}