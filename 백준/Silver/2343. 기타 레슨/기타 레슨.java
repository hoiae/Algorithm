import java.io.*;
import java.util.*;
public class Main {
	static int n,m;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		int left = 0;
		int right = 0;
		
		for(int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			left = Math.max(left, value);
			right += value;
			arr[i] = value;
		}
		
//		System.out.println(count(17));
		while(left <= right) {
			int mid = (left + right) / 2;
			if(count(mid) > m) {//m보다 큰 경우,길이를 늘린다.
				left = mid + 1;
			}else {//mid < m 인경우 길이를 줄인다.
				right = mid - 1;
			}
		}
		
		System.out.println(left);
	}
	private static int count(int size) {
		int sum = 0;
		int cnt = 0;

		for(int i = 0; i < n; i++) {
			if(sum + arr[i] > size) {
				cnt++;
				sum = arr[i];
				continue;
			}
			
			sum += arr[i];
		}
		
		if(sum != 0) cnt++;
		
		return cnt;
	}
}