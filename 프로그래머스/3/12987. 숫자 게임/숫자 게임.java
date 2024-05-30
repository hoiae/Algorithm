import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int index = 0;
        int score = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = index; j < B.length; j++){
                if(A[i] < B[j]){
                    score++;
                    index = j + 1;
                    break;
                }
            }
        }
        return score;
    }
}