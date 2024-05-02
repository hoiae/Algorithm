import java.io.*;
import java.util.*;

public class Main {
	static int n,k;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		
		long left = 1;
		long right = k;
		
		while(left < right) {
			long mid = (left + right)/2;
			//개수를 센다
			long cnt = 0;
			for(int i = 1; i <= n; i++) {
				cnt += Math.min(mid/i, n);
				
			}
			
			if(cnt < k) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		
		System.out.println(left);
	}

}