import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int day = 1;
        int cnt = 0;
        for(int i = 0; i <progresses.length; i++){
            int percent = progresses[i] + (speeds[i] * day);
            if(percent < 100){
                if(cnt != 0){
                    list.add(cnt);
                    cnt = 0;
                }
              while(percent < 100){
                percent = percent + speeds[i];
                day++;
              }
                cnt++;
            }else{
                cnt++;
            }
        }
        
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
       
        return answer;
    }  
}