import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        //n * m
        //(1,1) -> (n,m);
        
        //오른족과 아래로만이동해서 학교까지 갈수 있는 '최단경로'의 개수
        int[][] dp = new int[n + 1][m + 1];
        
        for(int[] puddle: puddles){
            dp[puddle[1]][puddle[0]] = -1;
        }
       
        
        dp[1][1] = 1;
        //왼쪽과 위의 값을 가지고 비교한다.
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(i == 1 && j == 1 || dp[i][j] == -1) continue;
                
                int left = dp[i][j-1];
                int up = dp[i-1][j];
                
                if(left == -1){
                    left = 0;
                }
                if(up == -1){
                    up =  0;
                }
                dp[i][j] = (left + up) % 1000_000_007; 
            }
        }
        
        int answer = dp[n][m];
        return answer;
    }
}