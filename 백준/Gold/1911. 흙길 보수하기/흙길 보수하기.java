//https://www.acmicpc.net/problem/1911
import java.util.*;
import java.io.*;

public class Main {
	static int N, L;// 웅덩이의 개수, 판자의 길이
	static Pool[] pools;
	static int cnt;

	static class Pool implements Comparable<Pool> {
		int start;
		int end;

		public Pool(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Pool p) {
			return Integer.compare(this.start, p.start);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		pools = new Pool[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pools[i] = new Pool(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(pools);

		int ans = solve();
		System.out.println(ans);

	}

	private static int solve() {
		int lastIdx = -1; // 다리의 가장 마지막 지점
		
		// 웅덩이를 순서대로 반복한다.
		// 시작지점이 웅덩이에 덮혀있는지 확인.
		// 현재 웅덩이를 다 덮을 정도로 판자를 올린다.
		// 판자가 올라간 구간을 모두 visit처리한다.
		for (int i = 0; i < N; i++) {
			Pool now = pools[i];
			// lastIdx와 비교
			// 다리가 없는 경우
			if (now.start > lastIdx) {
				lastIdx = getLastIndex(now.start, now.end - 1);
			}
			// 다리가 일부만 걸쳐있는 경우
			else if(now.start <= lastIdx && now.end - 1 > lastIdx ){
				lastIdx = getLastIndex(lastIdx + 1, now.end - 1);
			}
			//모두 다리에 걸쳐있는 경우
		}
		return cnt;
	}

	private static int getLastIndex(int start, int end) {
		int lastIdx = start - 1;
		int diff = end - lastIdx;
		int val = L * (diff/L);
		if(diff % L > 0) {
			val += L;
		}
		lastIdx += val;
		cnt += val/L;
	
		return lastIdx;
	}

}
