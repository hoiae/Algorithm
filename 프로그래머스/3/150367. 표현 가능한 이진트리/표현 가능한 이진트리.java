import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        int[] ans = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            String binary = Long.toBinaryString(numbers[i]);
            //포화 이진트리 노드의 개수는  2^h - 1 //h는 높이
            int size = 1;
            while(size - 1 < binary.length()){
                size = size << 1;
              
            }
            size--;
            //size와의 차이 만큼 앞에 0을 붙임
            StringBuilder sb = new StringBuilder(binary);
            for(int j = 0; j < size - binary.length(); j++){
                sb.insert(0,"0");
            }
            
            //dfs하며 유효한지 판단함.
            if(dfs(sb.toString())){
                ans[i] = 1;
            }
        }
        
   
        
//         for(int i = 0; i < numbers.length; i++) {
//         	String cur = Long.toBinaryString(numbers[i]);
//         	int j = 0;
//         	while((int)Math.pow(2, j)-1 < cur.length()) {
//         		j++;
//         	}
//         	while((int)Math.pow(2, j)-1 != cur.length()) {
//         		cur = "0"+ cur;
//         	}
//         	if(dfs(cur)) {
//         		ans[i] = 1;
//         	}
//         }
  
        //0111111
        return ans;
    }
    private static boolean dfs(String binary){
        int mid = (binary.length() - 1) / 2;
        char root = binary.charAt(mid);
        String left = binary.substring(0, mid);
        String right = binary.substring(mid + 1, binary.length());
        
        if(root == '0' &&
          (left.charAt((left.length() - 1)/2) == '1' || right.charAt((right.length() - 1) / 2) == '1')){
            return false;
        }
      
        
        if(left.length() >= 3){
            if(!dfs(left) || !dfs(right)){
                return false;
            }
        }
        return true;
    }
}