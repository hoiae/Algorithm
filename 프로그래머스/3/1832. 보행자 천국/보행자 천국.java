import java.util.*;
class Solution {
    static int m,n;
    static int[][] map;
    static int[][][] dp;//[r][c][0] = 왼쪽에서 오는 경우, [1] = 위에서 오는 경우
    static int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        this.m = m;
        this.n = n;
        this.map = cityMap;
        
        dp = new int[m + 1][n + 1][2];
        //dp채우기 
        dp[0][0][0] = 1;
        for(int r = 0; r < m; r++){
            for(int c =0; c < n; c++){
                //현재 위치가 0인경우
                //왼쪽, 위쪽의 값을 받아옴
                if(map[r][c] == 0){
                    //오른쪽
                    dp[r][c + 1][0] += (dp[r][c][0] + dp[r][c][1]) % MOD;
                    //아래
                    dp[r + 1][c][1] += (dp[r][c][0] + dp[r][c][1]) % MOD;
                    continue;
                }
                 //2인 경우
                    //왼쪽에 경우, 왼쪽에서 온 값만 받음.
                    //위쪽의 경우, 위쪽에서 온 값만 받음.
                if(map[r][c] == 2){
                    //오른쪽
                    dp[r][c + 1][0] += (dp[r][c][0])%MOD;
                    //아래
                    dp[r + 1][c][1] += (dp[r][c][1])%MOD;
                    continue;
                }
            }
        }

    
        int answer = (dp[m - 1][n - 1][1] + dp[m - 1][n - 1][0])%MOD;
        return answer;
    }
}