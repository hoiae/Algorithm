class Solution {
    static int[][] sums;
    public int solution(int[][] board, int[][] skill) {
        //skill[][0] == 1, -
        //skill[][0] == 2, +
        sums = new int[board.length+1][board[0].length+1];
        
        for(int[] command : skill){
            if(command[0] == 1){
                sums[command[1]][command[2]] += -command[5];//좌측상단
                sums[command[3] + 1][command[4] + 1] += -command[5];//우측하단
                sums[command[3] + 1][command[2]] += command[5];//좌측하단
                sums[command[1]][command[4] + 1] += command[5];//우측상단
            }else{
                sums[command[1]][command[2]] += command[5];//좌측상단
                sums[command[3] + 1][command[4] + 1] += command[5];//우측하단
                sums[command[3] + 1][command[2]] += -command[5];//좌측하단
                sums[command[1]][command[4] + 1] += -command[5];//우측상단
            }
        }
        
        // 구간합 구하기
        // 상단에서 하단으로 합
        for(int r = 1; r < sums.length; r++){
            for(int c = 0; c < sums[0].length; c++){
                sums[r][c] += sums[r - 1][c];           
            }
        }
        //좌측에서 우측으로 합
        for(int c = 1; c < sums[0].length; c++){
            for(int r = 0; r < sums.length; r++){
                sums[r][c] += sums[r][c - 1];           
            }
        }
        
        //sums와 board의 합을 구함
        int cnt = 0;
        for(int r = 0; r < sums.length-1; r++){
            for(int c= 0;  c<sums[0].length-1; c++){
                if(sums[r][c] + board[r][c] > 0){
                    cnt++;
                }
            }
        }
        
        int answer = cnt;
        return answer;
    }
}