import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        int shootingPoint = 0;
        int cnt = 0;
        for(int i = 0; i < targets.length; i++){
            if(shootingPoint <= targets[i][0]){
                cnt++;
                shootingPoint = targets[i][1];
                continue;
            }
        }
        int answer = cnt;
        return answer;
    }
}