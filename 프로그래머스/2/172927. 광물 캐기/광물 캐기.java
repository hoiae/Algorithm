import java.io.*;
import java.util.*;

class Solution {
    /*
        picks[다이아,철,돌]
        minerals
    */
    static int[] picks;
    static String[] minerals;
    static int min;
    static int[][] fatigue = {{1,1,1},{5,1,1},{25,5,1}};
    public int solution(int[] picks, String[] minerals) {
        //fatigue
        this.picks = picks;
        this.minerals = minerals;
        
        
        //depth, 총곡괭이의 개수, 미네랄 개수, 점수
        min = Integer.MAX_VALUE;
        dfs(0, 0, Arrays.stream(picks).sum(), minerals.length, 0);
        int answer = min;
        return answer;
    }
    
    private static void dfs(int picksDepth,int mineralDepth, int pickLimit, int mineralLimit, int score){
        if(picksDepth == pickLimit || mineralDepth > mineralLimit){
            min = Math.min(score, min);
            return;
        }
        
        //반복문을 순회하며 곡괭이를 뽑는다.
        for(int i = 0; i < 3; i++){
            if(picks[i] > 0){
                picks[i]--;
                
                
                int mineralIndex = mineralDepth;
                //5개를 연속으로 캔다!
                int addFatigue = 0;
                int cnt = 0;
                while(cnt < 5 && mineralIndex < mineralLimit){
                    int mineralType = 0;
                    if(minerals[mineralIndex].equals("iron")){
                        mineralType = 1;
                    }else if(minerals[mineralIndex].equals("stone")){
                        mineralType = 2;
                    }       
                    addFatigue += fatigue[i][mineralType];
                    mineralIndex++;
                    cnt++;
                }
                
                dfs(picksDepth + 1, mineralIndex, pickLimit, mineralLimit, score + addFatigue);
                
                picks[i]++;
            }
        }
        
    }
}