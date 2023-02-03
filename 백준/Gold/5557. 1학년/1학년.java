
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1학년
public class Main {
    static int n;
    static int[] nums;
    static long[][] dp; //i번째까지 숫자를 사용하여, j를 만드는 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        dp = new long[n + 1][21];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][nums[1]] = 1;
        for (int i = 2; i <= n - 1; i++) { //마지막은 자리의 수(nums[])는 결과이므로 제외
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) {
                    int minus = j - nums[i];
                    int plus = j + nums[i];
                    if (minus >= 0 && minus <= 20) {
                        dp[i][minus] += dp[i - 1][j];
                    }
                    if (plus >= 0 && plus <= 20) {
                        dp[i][plus] += dp[i - 1][j];
                    }
                }
            }
        }

        System.out.println(dp[n - 1][nums[n]]);
    }
}
