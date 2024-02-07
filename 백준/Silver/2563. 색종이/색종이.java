import java.util.*;
import java.io.*;
public class Main {
	static boolean[][] map;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		map = new boolean[10_000 + 1][10_000 + 1];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y =Integer.parseInt(st.nextToken());
			int x =Integer.parseInt(st.nextToken());
			
			for(int j = x; j < x + 10; j++) {
				for(int k = y; k < y + 10; k++) {
					if(map[j][k]) {
						cnt++;
					}else {
						map[j][k] = true;
					}
				}
			}
			
		}
		System.out.println(100 * n - cnt);
	}

}