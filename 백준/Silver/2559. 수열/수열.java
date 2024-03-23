import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int l = 0;
		int r = k - 1;

		int sum = 0;
		for (int i = l; i <= r; i++) {
			sum += nums[i];
		}

		int max = sum;
		while (r < n - 1 && l <= r) {
			sum += nums[++r];
			sum -= nums[l++];
			max = Math.max(max, sum);
		}
		System.out.println(max);

	}
}