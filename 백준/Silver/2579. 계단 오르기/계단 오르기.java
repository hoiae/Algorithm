import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n + 1];
		int ans = 0;
		if(n <= 2) {
			System.out.println(Arrays.stream(nums).sum());
			return;
		}
		
		dp[1] = nums[1];
		dp[2] = dp[1] +nums[2];
		
		for(int i = 3;  i <= n; i++) {
			dp[i] = Math.max(dp[i - 2] , dp[i - 3] + nums[i - 1]) + nums[i];
		}
		
		System.out.println(dp[n]);
		
	}

}
