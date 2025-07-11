class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] map = new boolean[n][n];
        
        for(int[] result : results){
            int a = result[0] - 1;
            int b = result[1] - 1;
            map[a][b] = true;
        }
        
        for(int k = 0 ; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i == j) continue;
                    if(map[i][k] && map[k][j]){
                        map[i][j] = true;
                    }
                }
            }
        }
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(map[i][j]||map[j][i]) cnt++;
            }
            if(cnt == n-1) answer++;
        }
        return answer;
    }
}