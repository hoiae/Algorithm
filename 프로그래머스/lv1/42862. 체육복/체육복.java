import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] borrow = new boolean[lost.length];
        int answer = n - lost.length;
        
        Arrays.sort(lost);        
        Arrays.sort(reserve);

        //도난 당한 사람이 여유옷을 가지고 있는 경우, 체육에 참여가능하지만 다른 사람들 대여해줄수는 없음.
        for(int l = 0; l < lost.length; l++){
            for(int i = 0; i < reserve.length; i++){
                if(lost[l] == reserve[i]){
                    borrow[l] = true;
                    reserve[i] = -1;
                    answer++;
                }
            }
        }
        
        for(int l = 0; l < lost.length; l++){    
            if(borrow[l] == true) continue;
            for(int i = 0; i < reserve.length; i++){
                if(lost[l] - 1 == reserve[i]){
                    answer++;
                    reserve[i] = -1;
                    break;
                }
                if(lost[l] + 1 ==  reserve[i]){
                    answer++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}