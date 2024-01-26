
import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static int N,M;
	static final int INF = 5000 + 1;
	static int minPerson = INF;
	static int minCnt = INF;
	public static void main(String[] args) throws  IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		for(int i = 0;  i <= N; i++) {
			for(int j = 0;  j <= N; j++) {
				if(i == j) continue;
				if(map[i][j] == 0) {
					map[i][j] = INF;
				}
			}
		}
//		printMap();
		
		solve();
		
		
	}
	private static void solve() {
		
		for(int mid = 1; mid <= N ; mid++) {
			for(int start = 1; start <= N; start++) {
				for(int end = 1; end <= N; end++) {
					if(map[start][end] > map[start][mid] + map[mid][end]) {
						map[start][end] = map[start][mid] + map[mid][end];
					}
				}
			}
		}
		
		for(int i = 1;  i <= N; i++) {
			int sum = 0;
			for(int j = 1; j <= N; j++) {
				if(i == j) continue;
				sum += map[i][j];
			}
			if(minCnt > sum) {
				minCnt = sum;
				minPerson = i;
			}else if(minCnt == sum) {
				minPerson = Math.min(minPerson, sum);
			}
		}
		
//		printMap();
		
		System.out.println(minPerson);
	}
	private static void printMap() {
		System.out.println();
		for(int i = 1;  i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
