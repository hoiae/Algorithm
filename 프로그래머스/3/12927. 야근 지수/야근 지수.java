import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        //야근 피로도는 야근을 시작한 시점에서, 남은 일의 작업량을 제곱하여 더한값
        
        //한시간에 작업량 1만큼 처리가능.
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            pq.add(work);
        }
        
        for(int i = 0; i < n; i++){
            if(pq.isEmpty()) break;
            int time = pq.poll();
            time --;
            if(time == 0) continue;
            pq.add(time);
        }
        
        long answer = 0;
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}