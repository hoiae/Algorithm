import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++){
            int start = Integer.parseInt(book_time[i][0].replace(":",""));
            int end = Integer.parseInt(book_time[i][1].replace(":","")) + 10;
            
            if(end % 100 >= 60){
                end += 40;
            }
            time[i][0] = start;
            time[i][1] = end;
        }
        Arrays.sort(time, (o1,o2) -> o1[0]-o2[0]);
    
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        for(int i = 0; i < time.length; i++){
            if(pq.isEmpty()){
                pq.add(time[i]);
            }else{
                if(pq.peek()[1] <= time[i][0]){
                    pq.poll();
                    pq.add(time[i]);
                }else{
                    pq.add(time[i]);
                }
            }
        }
        
        return pq.size();
    }
}