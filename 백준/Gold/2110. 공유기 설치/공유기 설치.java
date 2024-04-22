import java.io.*;
import java.util.*;

public class Main {
	static int n,c;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for(int i = 0 ; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		//시작과 끝점을 기준으로 c를 배치한다.
		int lo = 1;
		int hi = arr[n - 1] + 1;
		
		while(lo < hi) {
			int mid = (lo + hi)/2;
			if(count(mid) > c) {
				//길이가 너무 짧으므로 길이를 늘인다.
				lo = mid + 1;
			}else if(count(mid) < c){
				//길이기 너무 긴 것이므로 길이를 줄인다.
				hi = mid;
			}else {
				//길이를 늘린다.
				lo = mid + 1;
			}
		}
		System.out.println(lo - 1);
	}

	private static int count(int len) {
		int lastPosition = arr[0];
		
		int cnt  = 1;
		for(int i = 1; i < n; i++) {
			if(arr[i] - lastPosition >= len) {
				cnt++;
				lastPosition = arr[i];
			}
		}
		return cnt;
	}

	

}