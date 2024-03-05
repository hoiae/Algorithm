import java.io.*;
import java.util.*;

public class Main {
	static int N,K;
	static boolean[] alphas;
	static int maxCount;
	static String[] strs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		strs = new String[N];
		for(int i = 0;  i < N; i++) {
			strs[i] = br.readLine();
			strs[i] = strs[i].substring(4, strs[i].length() - 4);
		}
		

		int ans = 0;
		alphas = new boolean[26];
		alphas['a'-'a'] = true; 
		alphas['n'-'a'] = true; 
		alphas['t'-'a'] = true; 
		alphas['i'-'a'] = true; 
		alphas['c'-'a'] = true; 
		K -= 5;
		
		if(K < 0) {
			System.out.println(ans);
			return;
		}
		
		maxCount = Integer.MIN_VALUE;
		combi(0,0);
		System.out.println(maxCount);
		
	}
	private static void combi(int index, int depth) {
		if(depth == K) {
			int cnt = 0;
			loop: for(int i = 0; i < N; i++) {
				String word = strs[i];
				for(char c : word.toCharArray()) {
					if(!alphas[c-'a']) {
						continue loop;
					}
				}
				cnt++;
			}
			maxCount = Math.max(maxCount, cnt);
			return;
		}
		
		for(int i = index; i < 26; i++) {
			if(!alphas[i]) {
				alphas[i] = true;
				combi(i + 1, depth + 1);
				alphas[i] = false;
			}
		}
		
	}

}