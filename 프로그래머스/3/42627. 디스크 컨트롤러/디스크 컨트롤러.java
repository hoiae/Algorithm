import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        //작업번호, 요청시각, 소요시간 대기큐
        
        //우선순위
        //소요시간 작음, 요청시간 빠름(작음), 작업 번호 작음
        
        //하드디스크는 한번에 하나의 작업만
        
        
        //대기큐에 넣는다 -> 뽑는다.
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            if(o1[2] != o2[2]){
                return o1[2] - o2[2];
                
            }else if(o1[1] != o2[1]){
                return o1[1] - o2[1];
                
            }else{
                return o1[0] - o2[0];
            }
        });
        
        //요청시간으로 jobs를 정렬한다.
        Arrays.sort(jobs, (o1,o2)->{
            return o1[0] - o2[0];
        });
        
        int timeSum = 0;
        int currentTime = 0;
        int n = jobs.length;
        int index = 0;
        while(index < n){
            //pq에 넣는다.
            while(index < n && jobs[index][0] <= currentTime){
                pq.add(new int[]{index,jobs[index][0], jobs[index][1]});
                index++;
            }
            
            //pq가 비어있지 않다면 작업을 수행한다.
            if(!pq.isEmpty()){
                int[] now = pq.poll();
                currentTime += now[2];
                timeSum += currentTime - now[1];
            }else {//만약 다음 요청까지 시간이 좀걸린다면?
                currentTime = jobs[index][0];
            }
        }
        while(!pq.isEmpty()){
            int[] now = pq.poll();
                currentTime += now[2];
                timeSum += currentTime - now[1];
        }
        
        int answer = timeSum / jobs.length;
        return answer;
    }
}