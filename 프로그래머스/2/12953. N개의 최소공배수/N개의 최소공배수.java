import java.util.*;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        int answer = 10000;
        
        for(int i = 100_000_000; i >= 1; i--){
            if(check(i,arr)){
                answer = i;
            }
        }
        
        return answer;
    }
    private boolean check(int lcm, int[] arr){
        for(int num : arr){
            if(lcm % num != 0){
                return false;
            }
        }
        return true;
    }
}