
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static final String ERROR = "error";

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			bw.write(solve() + "\n");
		}

		bw.flush();
		bw.close();
	}

	private static String solve() throws IOException {

		String commands = br.readLine();
		int n = Integer.parseInt(br.readLine());

		String input = br.readLine();
		String[] nums = input.substring(1, input.length() - 1).split(",");

		// deque에 추가
		Deque<Integer> dq = new ArrayDeque<>();
		for (String num : nums) {
			if (num.equals(""))
				continue;
			dq.offer(Integer.parseInt(num));
		}

		// 명령어 실행
		boolean isForward = true;
		for (int i = 0; i < commands.length(); i++) {
			char command = commands.charAt(i);
			if (command == 'R') {// 뒤집기
				isForward = !isForward;
			} else {
				if (dq.size() <= 0) {
					return ERROR;
				}
				if (isForward) {
					dq.pollFirst();

				} else {
					dq.pollLast();

				}
			}
		}

		//
		if (isForward) {
			return dq.toString().replace(" ", "");
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (int i = dq.size(); i > 0; i--) {
				sb.append(dq.pollLast());
				if (i != 1) {
					sb.append(",");
				}
			}
			sb.append("]");
			return sb.toString();
		}
	}

}
