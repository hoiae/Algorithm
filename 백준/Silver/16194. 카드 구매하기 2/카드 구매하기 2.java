
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

        dp[1] = Integer.parseInt(st.nextToken()); //1개를 구입하는 유일한 방법

        for (int i = 2; i <= n; i++) {
            dp[i] = getMin(i, Integer.parseInt(st.nextToken())); //해당 개수(i)를 구입할 수 있는 가장 저렴한 금액 구하기
        }

        System.out.println(dp[n]);
    }

    private static int getMin(int index, int p) {
        int min = index * dp[1]; //1개로 해당 개수가 전부 구성되었을 경우

        //int[] dp에 저장되어있는 요소들로 가장 높은 금액을 찾음.
        for(int i = 1; i < index; i++){
            min = Math.min(min, dp[i] + dp[index - i]);
        }

        //Pi와 비교하여 가장 큰 금액을 반환함.
        return Math.min(min,p);
    }
}
