import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;  i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                coins[j] = Integer.parseInt(st.nextToken());
            }
            int money = Integer.parseInt(br.readLine());
            sb.append(solve(coins,money)+"\n");
        }
        System.out.println(sb);
    }
    private static int solve(int[] coins, int money){
        int dp[][] = new int[coins.length + 1][money + 1];
        
        //작은 값부터 순서대로 채운다.
        for(int i = 1;  i < coins.length; i++){
            int value = coins[i];
            for(int j = 1;  j <= money; j++){
                if(j == value){
                    dp[i][j] = 1;
                }
                if(j - value > 0){
                    dp[i][j] = dp[i][j - value] + dp[i - 1][j] + dp[i][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j];
                }
            }
        }
        return dp[coins.length-1][money];
    }
}
