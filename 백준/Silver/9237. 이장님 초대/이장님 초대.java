import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] trees = new Integer[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i< n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees, Collections.reverseOrder());
		
		int max = 0;
		for(int i = 0; i< n; i++) {
			max = Math.max(max, trees[i] + i + 1);
		}
		System.out.println(max+1);
		
	}

}