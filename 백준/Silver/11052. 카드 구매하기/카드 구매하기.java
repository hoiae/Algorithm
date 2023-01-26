
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[n + 1];

        dp[1] = Integer.parseInt(st.nextToken()); //비교할 방법이 없음 1개를 구입하는 유일한 방법

        for (int i = 2; i <= n; i++) {
            dp[i] = getMax(i, Integer.parseInt(st.nextToken()));
        }

        System.out.println(dp[n]);
    }

    private static int getMax(int index, int p) {
        int max = index * dp[1];

        for(int i = 1; i < index; i++){
            max = Math.max(max, dp[i] + dp[index - i]);
        }

        int result = Math.max(max,p);
        return result;
    }
}
