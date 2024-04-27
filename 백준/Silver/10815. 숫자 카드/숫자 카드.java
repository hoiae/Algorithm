import java.io.*;
import java.util.*;
public class Main {
	static int n,m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] cards = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			int target =  Integer.parseInt(st.nextToken());
			int left = 0;
			int right = n - 1;
			int ans = 0;
			while(left <= right) {
				int mid = (left + right)/2;
				if(cards[mid] < target) {
					left = mid + 1;
				}else if(cards[mid] == target) {
					ans = 1;
					break;
				}else {					
					right = mid - 1;
				}
			}
			sb.append(ans+" ");
		}		
		
		System.out.println(sb);
	}

}