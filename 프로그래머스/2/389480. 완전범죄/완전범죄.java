import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        //두 도둑 모두 경찰에 붙잡히지 않도록 모든 물건을 훔쳤을때
        //-> 둘다 잡히면 안됨, 모든 물건을 훔침.
        
        //A 도둑이 남긴 흔적의 누적개수의 최솟값을 return.
        //두 도둑 모두 경찰에 붙잡히게 할 수 없다면 -1 return.
        
        //dp[i][0] -> a가 훔침, dp[i][1] -> b가 훔침
        int size = info.length;
        
        //정해진 구간내에서, n은 최소, m은 최대를 지향한다.
        //dp[i][b] = a -> a = 누적된 A도둑의 흔적, b = 누적된 B 도둑의 흔적
        int[][] dp = new int[m][size + 1];
        
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[0][0] = 0;
        
        for(int i = 0; i < size; i++){
            int aTrace = info[i][0];
            int bTrace = info[i][1];
            
            for(int b = 0; b < m; b++){
                if(dp[b][i] == Integer.MAX_VALUE) continue;
                
                //a 가 훔칠 수 있는 경우
                if(dp[b][i] + aTrace < n){
                    dp[b][i + 1] = Math.min(dp[b][i]  + aTrace, dp[b][i + 1] );
                }
                    
                //b 가 훔칠 수 있는 경우
                if(b + bTrace < m){
                    dp[b + bTrace][i + 1] = Math.min(dp[b + bTrace][i + 1] , dp[b][i]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            if(dp[i][size] < n){
                answer = Math.min(answer, dp[i][size]);
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    
    }
}