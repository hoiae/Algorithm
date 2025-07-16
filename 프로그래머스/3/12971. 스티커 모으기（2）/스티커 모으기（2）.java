class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        //한쪽을 뜯으면 양쪽을 못쓴다.
        
        //스티커를 뜯어내서 얻을 수 있는숫자의 합의 최댓값
        int n = sticker.length;
        if(n == 1){
            return sticker[0];
        }
        int[][] dp = new int[n][2]; //[i][1] 선택 했을때의 값, [i][0] 선택하지 않았을 때의 값
        int[][] dp2 = new int[n][2]; //[i][1] 선택 했을때의 값, [i][0] 선택하지 않았을 때의 값
        
        //0
        dp[0][1] = sticker[0];
        
        dp[1][0] = sticker[0];
        dp[1][1] = sticker[1];
        
        //
        dp2[1][1] = sticker[1];
        for(int i = 2; i < n; i++){
            //선택한경우의 최댓값은
            dp[i][1] = sticker[i] + Math.max(dp[i - 2][1], dp[i-2][0]);
            dp2[i][1] = sticker[i] + Math.max(dp2[i - 2][1], dp2[i-2][0]);

            //선택하지 않은 경우의 최댓값은
            dp[i][0] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][0]), Math.max(dp[i - 2][0], dp[i - 2][1]));
            dp2[i][0] = Math.max(Math.max(dp2[i - 1][1], dp2[i - 1][0]), Math.max(dp2[i - 2][0], dp2[i - 2][1]));

        }
    
        int max = Math.max(Math.max(dp[n - 2][0],dp[n-2][1]), Math.max(dp2[n - 1][1], dp2[n - 1][0]));

        return answer = max;
    }
}