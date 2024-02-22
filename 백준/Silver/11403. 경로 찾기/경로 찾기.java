import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
				
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;  j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					map[i][j] = 101;
			}
		}
		
		
		
		for(int mid = 0; mid < n; mid++) {
			for(int start = 0; start < n; start++) {
				for(int end = 0; end < n; end++) {
					if(map[start][end] > map[start][mid] + map[mid][end]) {
						map[start][end] = map[start][mid] + map[mid][end];
					}
				}
			}
		}
		

		
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] ==101) map[i][j] = 0;
				int value = (map[i][j] != 0) ? 1 : 0;
				System.out.print(value+" ");
			}
			System.out.println();
		}
		
	}


}