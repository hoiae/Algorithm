import java.util.*;
class Solution {
    public int solution(int[] arr) {
        
        int lcm = arr[0];
        
        for(int num : arr){
            lcm = lcm(lcm, num);
        }
        
        return lcm;
    }
    private int lcm(int a, int b){
       return  a * b / gcm(a,b);
    }
    
    private int gcm(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}