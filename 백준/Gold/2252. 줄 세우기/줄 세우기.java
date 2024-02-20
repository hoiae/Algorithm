import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] indegrees;
	static ArrayList<Integer>[] infos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		indegrees = new int[N + 1];
		infos = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			infos[i] = new ArrayList<>();
		}

		// a가 b보다 앞에 서야한다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			indegrees[b]++;
			infos[a].add(b);
		}

		//초기 값
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegrees[i] == 0) {
				q.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now+" ");
			for(int next : infos[now]) {
				indegrees[next]--;
				if(indegrees[next ] == 0) {
					q.add(next);
				}
			}
		}
		System.out.println(sb);
	}

}