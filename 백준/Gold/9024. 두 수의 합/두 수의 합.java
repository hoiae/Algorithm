import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			sb.append(solve() + "\n");
		}
		System.out.println(sb);
	}

	private static int solve() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);
		
		
//		System.out.println(Arrays.toString(nums));
//		System.out.println("k="+k);
		int l = 0;
		int r = n - 1;
		int minDiff = Integer.MAX_VALUE; 
		int cnt = 0;
		while (l < r) {
			int sum = nums[l] + nums[r];
			int diff = Math.abs(sum - k);
//			System.out.println("l="+l+", r="+r+", sum="+sum + ", minDiff="+minDiff+", diff="+diff);
			if(sum < k) {
				l++;
			}else {
				r--;
			}
			
			if(diff < minDiff) {
//				System.out.println("in if");
//				System.out.println("l="+l+", r="+r+", diff="+diff);

				minDiff = diff;
				cnt = 1;
			}else if(diff == minDiff) {
				cnt++;
			}
		}
		return cnt;
	}
}