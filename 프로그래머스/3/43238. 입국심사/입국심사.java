import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        //끝나는 시간으로 정렬
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = right;
        
        
        while(left <= right){
            long cnt = 0;
            long mid = (left + right) / 2; //사용할 시간
            
            for(int time: times){
                cnt += mid/time;
            }
            
            //범위를 줄임
            if(cnt >= n){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            
        }
        
        
        return answer;
    }
}