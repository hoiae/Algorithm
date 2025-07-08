import java.util.*;

class Solution {
    static int[][] dp;
    static int[][] board;
    static int[] dx = new int[]{-1,1,0,0,-1,-1,1,1};
    static int[] dy = new int[]{0,0,-1,1,-1,1,-1,1};
    public int solution(String numbers) {
        
        //제자리 1
        //상하좌우 이동 후 2
        //대각선 인전합 숫자 3
        //위 규칙에 따라 가중치의 합이 최소가 되는 경로는 따른다.
        
        dp = new int[13][13];
        //* = 10, 0 = 11, #=12
        
        //각 번호에서 다른 번호로 이동하는 최단 거리를 기록한다.
        board = new int[4][3];
        int number = 1;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = number++;
            }
        }
        
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                dijkstra(i,j);
            }
        }
           
        int left = 4;
        int right = 6;
        int[][][] dp2 = new int[numbers.length()+1][13][13];//[i번째][왼][오] = 가중치합;
        for(int i = 0; i <= numbers.length(); i++){
            for(int j = 0; j < 13; j++){
                Arrays.fill(dp2[i][j], Integer.MAX_VALUE);
            }
        }
        // for(int i = 0; i < numbers.length(); i++){
        //     for(int j = 0; j < 13; j++){
        //         System.out.println(Arrays.toString(dp2[i][j]));
        //     }
        // }
        
        dp2[0][4][6] = 0;
        
        for(int i = 0; i < numbers.length(); i++){
            int num = numbers.charAt(i) - '0';
            if(num == 0) num = 11;
            
            for(int l = 1; l <13; l++){
                for(int r = 1; r < 13; r++){
                    if(l == r) continue;
                    if(dp2[i][l][r] == Integer.MAX_VALUE) continue;
                    //왼쪽 이동
                    dp2[i+1][num][r] = Math.min(dp2[i+1][num][r], dp[l][num] + dp2[i][l][r]);
                    
                    //오른쪽 이동
                    dp2[i+1][l][num] = Math.min(dp2[i+1][l][num], dp[r][num] + dp2[i][l][r]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        
        for(int l = 1; l <= 12; l++){
            for(int r = 1; r <= 12; r++){
                answer = Math.min(answer, dp2[numbers.length()][l][r]);
            }
        }
        return answer;
    }
    private void dijkstra(int x, int y){
        int currentNumber = board[x][y];
        Arrays.fill(dp[currentNumber], Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq =new PriorityQueue<>((o1,o2)->{
            return o1[3] - o2[3];
        });
        
        dp[currentNumber][currentNumber] = 0;
        pq.add(new int[]{x,y,currentNumber, 0});
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int cx = now[0];
            int cy = now[1];
            int number = now[2];
            int cost = now[3];
            
            //뭔가 이상해
            if(dp[currentNumber][number] < cost){
                continue;
            }
            
            //상하좌우 이동
            for(int i = 0; i < 8; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(isOutOfRange(nx,ny)) continue;
                
                int nextNumber = board[nx][ny];
                int nextCost = i < 4 ? 2 : 3; 
                if(dp[currentNumber][nextNumber] > dp[currentNumber][number] + nextCost){
                    dp[currentNumber][nextNumber] = dp[currentNumber][number] + nextCost;
                    pq.add(new int[]{nx,ny,nextNumber, dp[currentNumber][nextNumber]});
                }
            }
        }
        dp[currentNumber][currentNumber] = 1;
        
    }
    private boolean isOutOfRange(int x, int y){
        if(x < 0 ||  x >= 4 || y  < 0 || y >= 3) return true;
        return false;
    }
}