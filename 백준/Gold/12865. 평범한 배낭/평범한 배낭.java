import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        //무게,가치
        int[] weights = new int[n + 1];
        int[] values = new int[n + 1]; 
        
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());    
        }
        
        //dp
        int[][] dp = new int[n + 1][k + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                if(weights[i] > j){
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                
                dp[i][j] = Math.max(dp[i-1][j], values[i] + dp[i-1][j-weights[i]]);
            }
        }
        System.out.println(dp[n][k]);
    }
}
