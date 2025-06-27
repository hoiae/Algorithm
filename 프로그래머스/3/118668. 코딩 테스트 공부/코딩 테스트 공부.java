import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        //dp[알고력][코딩력] = 시간
        //초기값은 alp, cop ~ problems alp_req, cop_req 최대값
        
        //2중 반복문을 사용해서 계속 가능한지 확인한다?
            //problems를 반복하면서 해당 값을 상용할 수 있는지 계속 확인한다.
            //
        int maxAlp = 0;
        int maxCop = 0;
        for(int[] problem : problems){
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        
        int[][] dp = new int[150 + 2][150 + 2];
        for(int i = 0; i <= 150; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        
        dp[alp][cop] = 0;
        
        for(int i = alp; i <= 150; i++){
            for(int j = cop; j <= 150; j++){
                //problems를 순회하며 충족되는 조건을 사용한다.
                for(int[] problem: problems){
                    int alp_req = problem[0];
                    int cop_req = problem[1];
                    int alp_rwd = problem[2];
                    int cop_rwd = problem[3];
                    int cost = problem[4];
                    if(i >= alp_req && j >= cop_req){
                        int nextAlp = Math.min(i + alp_rwd, 150);
                        int nextCop = Math.min(j + cop_rwd, 150);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + cost);
                    }
                }
                //그냥 1씩 올리는 경우
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = maxAlp; i <= 150; i++){
            for(int j = maxCop; j<=150; j++){
                answer = Math.min(answer, dp[i][j]);
            }
        }
        return answer;
    }
}