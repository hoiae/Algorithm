import java.io.*;
import java.util.*;

public class Main {
	/*높이 순서대로 정렬 
	 * 현재 높이와 동일하거나 작은 경우에 l++*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		
		int[] heights = new int[n];
		for(int i = 0; i < n; i++) {
			heights[i] = sc.nextInt();
		}
		
		Arrays.sort(heights);
		
		for(int height : heights) {
			if(height > l) break;
			l++;
		}
		
		System.out.println(l);
	}

}