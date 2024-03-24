import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int[][] dp = new int[n + 1][money.length + 1];
        for(int change = 0; change <= n; change++){
            
            for(int index = 0; index < money.length; index++){
                // int value  = money[index];
                if(change == 0) {
                    dp[change][index+1] = 1;
                    continue;
                }
                
                if(money[index] > change){
                    dp[change][index + 1] = dp[change][index];
                }else{
                    int spareChange = change - money[index];
                    dp[change][index + 1] = (dp[change][index] + dp[spareChange][index+1]);
                }
            }
        }
        
        return dp[n][money.length]  % 1_000_000_007 ;
        
    }
}