import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        //끝나는 지점 기준으로 오름차순 정렬한다.
        Arrays.sort(targets, (o1,o2) -> o1[1] - o2[1]);
        int shootingPoint = 0;
        int cnt = 0;
        for(int i = 0; i < targets.length; i++){
            if(shootingPoint <= targets[i][0]){
                cnt++;
                shootingPoint = targets[i][1];
            }
        }
        return cnt;
    }
}