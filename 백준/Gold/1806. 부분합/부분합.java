
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        long sum = 0;
        long min = Long.MAX_VALUE;

        while (true) {
            if (sum >= s) {
                min = Math.min(min, end - start);
                sum -= nums[start];
                start++;
            } else if (end >= n) {
                break;
            } else {
                sum += nums[end];
                end++;
            }
        }
        if (min == Long.MAX_VALUE) System.out.println(0);
        else {
            System.out.println(min);
        }
    }
}

