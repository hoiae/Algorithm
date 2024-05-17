import java.io.*;
import java.util.*;
public class Main {
	static int N,M;
	static StringBuilder sb;
	static Integer[] nums;
	static Set<String> visit;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		visit = new HashSet<>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new Integer[N];
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		dfs(0);
		System.out.println(sb);
	}
	private static void dfs(int depth) {
		if(depth == M) {
			StringBuilder temp = new StringBuilder();
			for(int i = 0; i < M; i++) {
				temp.append(arr[i]+" ");
			}
			if(!visit.contains(temp.toString())) {
				visit.add(temp.toString());
				sb.append(temp.toString()+"\n");
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			arr[depth] = nums[i];
			dfs(depth + 1);
		}
	}

}