import java.util.*;
import java.io.*;

public class Main {
	
	static int N,R,C;
	static int seq;
	static boolean isEnd;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		//3
		int len = (int) Math.pow(2, N);
		dfs(0,0,len);
		System.out.println(seq);
	}
	private static void dfs(int x, int y, int length) {
		if(length == 1) {
			return;
		}
		
		//4개로 나누어서 생각
		int halfLength = length / 2;
			
		//2사분면
		if(R < x + halfLength  && C < y + halfLength) {
			dfs(x, y, halfLength);
		}
		//1사분면
		else if(R < x + halfLength  && C >= y + halfLength) {
			seq += halfLength * halfLength;
			dfs(x , y + halfLength, halfLength);
		}
		//3사분면
		else if(R >= x + halfLength  && C < y + halfLength) {
			seq += (halfLength * halfLength) * 2;
			dfs(x + halfLength, y, halfLength);
		}
		//4사분면
		else {
			seq += (halfLength * halfLength) * 3;
			dfs(x + halfLength, y + halfLength, halfLength);
		}	
	}
}
