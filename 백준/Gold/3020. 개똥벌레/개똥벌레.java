import java.io.*;
import java.util.*;

public class Main {
	static int n,h;
	static int[] down;
	static int[] up;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		down = new int[n/2];
		up = new int[n/2];
		for(int i = 0; i < n/2; i++) {
			down[i] = Integer.parseInt(br.readLine());
			up[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(down);
		Arrays.sort(up);
		
		int minCrush = Integer.MAX_VALUE;
		int cnt = 0;
		
		for(int i = 1; i <= h; i++) {
			int crush = lowBound(i,down) +lowBound(h - i + 1,up);
			if(crush < minCrush) {
				minCrush = crush;
				cnt = 1;
			}else if( crush == minCrush) {
				cnt++;
			}
		}
		
		System.out.println(minCrush + " "+ cnt);
	}
	private static int lowBound(int height, int[] arr) {
		int left = 0;
		int right = n/2;
		while(left < right) {
			int mid =(left+right)/2;
			if(arr[mid] >= height) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		
		return n/2 -left;
	}

}