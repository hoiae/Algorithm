import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        //진출 지점을 기준으로 정렬한다.
        //순서대로 인덱스를 증가시키면서, 해당 값이 어떤 상황인지 파악한다.
        
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1],o2[1]));
        
        int answer = 1;
        int camera = routes[0][1];
        for(int i = 1; i < routes.length; i++){
            if(routes[i][0] > camera){
                answer++;
                camera = routes[i][1];
            }
        }
        return answer;
    }
}