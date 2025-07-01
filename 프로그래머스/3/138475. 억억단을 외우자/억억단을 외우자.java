import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        
        //초기 세팅
        int[] divisors = new int[e + 1];
        for(int i = 1; i <= e; i++){
            for(int j = i; j <= e; j += i){
                divisors[j]++;
            }
        }
        
        int[] reverse = new int[e + 1];
        
        reverse[e] = e;
        int maxCnt = divisors[e];
        for(int i = e-1; i >= 1; i--){
            if(divisors[i] >= maxCnt){
                reverse[i] = i;
                maxCnt = divisors[i];
            }else{
                reverse[i] = reverse[i + 1];
            }
        }
        
        
        int[] answer = new int[starts.length];
        for(int i = 0; i < starts.length; i++){
            answer[i] = reverse[starts[i]];
            
        }
        
        return answer;
    }
}