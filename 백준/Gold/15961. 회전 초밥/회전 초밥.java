import java.io.*;
import java.util.*;
public class Main {
	
	static int N,D,K,C;
	static int[] counts;
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	
		//다양한 종류를 구한다.
		//인덱스 별/ 어떤 종류인지 저장. flavors
		int[] dishes = new int[N + K];
		for(int i = 0;  i < N; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
		
		
		for(int i = 0; i < K ; i++) {
			dishes[N + i] = dishes[i];
		}
		
		counts = new int[D + 1];
		
		Set<Integer> window = new HashSet<>();
		for(int i = 0; i < K; i++) {
			window.add(dishes[i]);
			counts[dishes[i]]++;
		}
		
		int l = 0;
		int r = K - 1;
		
		int max = 0;
		while(r < N + K - 1) {
			//l반영
			if(--counts[dishes[l]] == 0) {
				window.remove(dishes[l]);
			}
			l++;
			
			//r반영
			r++;
			if(counts[dishes[r]] == 0)
				window.add(dishes[r]);
			counts[dishes[r]]++;
			
			
			//종류카운트
			window.add(C);
			max = Math.max(max,window.size());
		}
		
		System.out.println(max);
		//종류를 어떻게 구분함? -> set사용
		//슬라이딩 윈도우를 통해서 set에 값을 C를 더하고 사이즈 파악
		
		//TODO
		//원형인것을 고려한다.
	}

}