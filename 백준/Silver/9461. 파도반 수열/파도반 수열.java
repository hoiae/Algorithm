import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		long[] dp = new long[100 + 1];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		
		for(int i = 4; i<=100; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			sb.append(dp[sc.nextInt()]+"\n");
		}
		
		System.out.println(sb);
	}

}