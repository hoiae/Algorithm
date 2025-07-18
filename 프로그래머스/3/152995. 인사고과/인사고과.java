import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int[] wh = {scores[0][0], scores[0][1]};
        
        Arrays.sort(scores, (o1,o2)->{
            if(o1[0] != o2[0]){
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });
        
        int sum = wh[0] + wh[1];
        int rank = 1;
        int maxB = 0;
        for(int[] score: scores){
            //-1을 반환해야할경우
            if(maxB > score[1]){
                if(score[0] == wh[0] && score[1] == wh[1]){
                    return -1;
                }
                continue;
            }
            maxB = score[1];
            
            if(score[0] + score[1] > sum){
                rank++;
            }
            

        }
        
        int answer = rank;
        return answer;
    }
}