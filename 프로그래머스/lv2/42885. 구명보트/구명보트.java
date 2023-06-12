import java.util.*;


class Solution {
    public int solution(int[] people, int limit) {

        Arrays.sort(people);
        
        int left = 0;
        int  cnt = 0;
        for(int i = people.length - 1; i >= 0; i--){
            if(people[i] == -1)
                continue;
            if(people[i] + people[left] <= limit){
                people[left] = -1;
                left++;
                
            }
            cnt++;
        }

        return cnt;
    }
}