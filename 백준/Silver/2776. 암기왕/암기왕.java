import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< t; i++) {
			
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[n];
			
			StringTokenizer st  = new StringTokenizer(br.readLine());
			for(int j = 0; j< n; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);

			int m = Integer.parseInt(br.readLine());
			st  = new StringTokenizer(br.readLine());
			for(int j = 0; j< m; j++) {
				int target = Integer.parseInt(st.nextToken());
				int left = 0;
				int right = n - 1;
				
				int ans = 0;
				while(left <= right) {
					int mid = (left + right)/2;
					
					if(nums[mid] == target) {
						ans = 1;
						break;
					}
					
					if(nums[mid] > target) {
						right = mid - 1;
					}else {
						left = mid + 1;
					}
				}
				sb.append(ans+"\n");
			}
		}
		System.out.println(sb);

		
	}
}