import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			sb.append(binary(target)+"\n");
		}
		System.out.println(sb);
	}
	private static int binary(int target) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] > target) {
				right = mid - 1;
			}else if(arr[mid] < target) {
				left = mid + 1;
			}else {
				return 1;
			}
		}
		return 0;
	}
}