import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIndex = 0;
        //commands의 길이 만큼 반복
        
            //i부터k까지 배열에 저장
            //오름차순 정렬
            //k번째 수 return할 배열에 저장
        for(int r = 0; r < commands.length; r++){
            int[] temp = new int[commands[r][1] - (commands[r][0] - 1)];//정렬에 사용할 배열
            int index = 0;
            for(int s = commands[r][0] - 1; s < commands[r][1]; s++){
                temp[index++] = array[s];
            }
            Arrays.sort(temp);
            answer[answerIndex++] = temp[commands[r][2] - 1];
        }
        return answer;
    }
}