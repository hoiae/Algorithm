import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R, X;
	static int[] nums;
	static int[] arr;
	static int cnt;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		arr = new int[N];
		visited = new boolean[N];
		combi(0, 0);
		System.out.println(cnt);

	}

	private static void combi(int start, int depth) {
		if(depth != 0) {
			int sum = Arrays.stream(arr).limit(depth).sum();
			int sub = arr[depth - 1] - arr[0];
			if(sum >= L && sum <= R && sub >= X) {
				cnt++;
			}			
		}
		
		if (depth == N) {	
			return;
		}
		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = nums[i];
				combi(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

}