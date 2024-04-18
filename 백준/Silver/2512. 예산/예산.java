import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int total;
	static int[] arr;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int left = 0;
		int right = 0;
		
		for(int i = 0; i< n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
		total = Integer.parseInt(br.readLine());
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if(sum(mid) > total) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		System.out.println(ans);
	}

	private static int sum(int up) {
		int sum = 0;
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i] <= up) {
				sum += arr[i];
				max = Math.max(max, arr[i]);
			}else {
				sum += up;
				max = Math.max(max, up);
			}
		}
		
		
		if(sum <= total) {
			ans = Math.max(ans, max);
		}
		return sum;
	}
}