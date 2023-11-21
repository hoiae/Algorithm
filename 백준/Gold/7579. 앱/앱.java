import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] memories = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n + 1][10000 + 1];
        for(int i = 1;  i <= n; i++){
            int memory = memories[i - 1];
            int cost = costs[i - 1];
            for (int j = 0; j <= 10000; j++) {
                if(j >= cost){
                    dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
                if(dp[i][j] >= m){
                    ans = Math.min(j, ans);
                }
            }
        }
        System.out.println(ans);
    }
}
