import java.util.*;
class Solution {
    static class Info implements Comparable<Info>{
        int start;
        int time;
        public Info(int start, int time){
            this.start = start;
            this.time = time;
        }
        @Override
        public int compareTo(Info i){
            return Integer.compare(this.time,i.time);
        }
        
    }
    public int solution(int[][] jobs) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        
        //우선순위큐에 넣음
        for(int[] job : jobs){
            pq.offer(new Info(job[0],job[1]));
        }
        
        int cnt = 0; //시간 측정하는 변수
        int sum = 0;
        while(!pq.isEmpty()){
            Queue<Info> q = new LinkedList<>();
            
            while(!pq.isEmpty() && pq.peek().start > cnt){
                q.offer(pq.poll());
            }
            
            if(pq.isEmpty()){
               cnt++;
            }else{
               cnt += pq.peek().time;
               sum += cnt - pq.poll().start;
            }
     
            for(Info i : q){
                pq.offer(i);
            }
        }
        return sum / jobs.length;
        
        
    }
}