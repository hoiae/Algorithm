import java.util.*;

class Solution {
    
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);  // 초기값을 -1로 설정
        
        //stack은 뒷큰수를 찾지 못한 인덱스를 저장한다.
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
           
            while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]){
                answer[stack.pop()] = numbers[i]; 
            }
        
            stack.add(i);
        }
        
        return answer;
    }
}