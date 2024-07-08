import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();
        
        int[] arr = new int[elements.length * 2];
        for(int i = 0; i < elements.length; i++){
            arr[i] = elements[i];
            arr[i + elements.length] = elements[i];
        }
        
        for(int i = 0; i < elements.length; i++){
            for(int j = 1; j <= elements.length; j++){
                sums.add(Arrays.stream(arr,i,i+j).sum());
            }
        }
        
        int answer = sums.size();
        return answer;
    }
}