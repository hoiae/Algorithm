
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MOD = (int)Math.pow(10,9);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //https://gre-eny.tistory.com/220
        int n = Integer.parseInt(br.readLine());
        long dp[][][] = new long[n + 1][10][1 << 10];//자리의 길이(N), 마지막숫자, 각 숫자의 사용여부

        for(int i = 1; i <= 9; i++){
            dp[1][i][1 << i] = 1;
        }

        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= 9; j++){
                for(int k = 0; k < (1<<10); k++){
                    if(j == 0){
                        dp[i][j][k | 1 << j] = (dp[i][j][k | 1 << j] + dp[i - 1][j + 1][k]) % MOD;
                    }
                    else if(j == 9){
                        dp[i][j][k | 1 << j] = (dp[i][j][k | 1 << j] + dp[i - 1][j - 1][k]) % MOD;
                    }
                    else{
                        dp[i][j][k | 1 << j] = (dp[i][j][k | (1 << j)] + dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for(int j = 0; j <= 9; j++){
            ans = (ans + dp[n][j][(1 << 10) - 1]) % MOD;
        }

        System.out.println(ans);
    }
}
