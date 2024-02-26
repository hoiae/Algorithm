import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			sb.append(solve()).append("\n");
		}
		System.out.println(sb);
	}

	private static String solve() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command1 = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if (command1.equals("I")) { // 입력
				int value = map.getOrDefault(num, 0) + 1;
				map.put(num, value);
			} else {
				if (map.size() == 0)
					continue;

				if (num == 1) {// 최댓값 삭제
					int value = map.lastKey();

					if (map.get(value) - 1 == 0) {
						map.remove(value);
					} else {
						map.put(value, map.get(value) - 1);
					}

				} else {// 최솟값 삭제
					int value = map.firstKey();
					if (map.get(value) - 1 == 0) {
						map.remove(value);
					} else {
						map.put(value, map.get(value) - 1);
					}

				}
			}
		}

		String ans = null;
		if(map.size() == 0) {
			ans = "EMPTY";
		}else {
			ans = String.valueOf(map.lastKey())+" "+ String.valueOf(map.firstKey());
		}
		return ans;
	}
}