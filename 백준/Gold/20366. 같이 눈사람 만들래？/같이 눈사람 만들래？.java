import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				int outSum = arr[i] + arr[j];
				int lo = i + 1;
				int hi = j - 1;
				while(lo < hi) {
					int inSum = arr[lo] + arr[hi];
					min = Math.min(min, Math.abs(outSum - inSum));
					if(inSum > outSum) { //outSum보다 큰 경우 크기를 줄인다.
						hi--;
					}else {
						lo++;
					}
				}
			}
		}
		System.out.println(min);
	}
}