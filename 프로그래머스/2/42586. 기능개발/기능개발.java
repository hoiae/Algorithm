import java.util.*;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            q.add(i);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int index = q.peek();
            int day = (100 - progresses[index]) / (speeds[index]);
            if((100 - progresses[index]) % (speeds[index]) > 0){
                day++;
            }
            
            int cnt = 0;
            while(!q.isEmpty()){
                index = q.peek();
                if((100 - progresses[index]) - (speeds[index] * day) > 0){
                    break;
                }
                q.poll();
                cnt++;
            }
            result.add(cnt);
        }
        int[] answer = result.stream().mapToInt(num -> num).toArray();
        return answer;
    }
}