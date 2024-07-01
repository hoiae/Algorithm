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
        for(int i = 1; i <= k; i++){//제한무게
            for(int j = 1; j <= n; j++){//상품인덱스
                if(weights[j] > i){
                    dp[j][i] = dp[j - 1][i];
                    continue;
                }
                
                //가방에 담을 수 있는 경우
                dp[j][i] = Math.max(dp[j - 1][i], values[j] + dp[j - 1][i - weights[j]]);
            }
        }
        System.out.println(dp[n][k]);
    }
}
