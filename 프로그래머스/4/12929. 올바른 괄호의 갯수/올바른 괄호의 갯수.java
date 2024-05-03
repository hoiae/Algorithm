import java.util.*;
class Solution {
    static int n;
    static int cnt;
    public int solution(int n) {
        this.n = n;
        
        //깊이, 사용한 '('의 개수
        dfs(0,0,"");
        return cnt;
    }
    private static void dfs(int depth, int left, String str){
        if(depth == n * 2){
            //유효한지 판단
            if(checkValid(str)){
                    cnt++;
            };   
            return;
        }
        
        //+(
        if(left < n){    
        dfs(depth + 1, left + 1, str+"(");
        }
        //+)
        if(depth - left < n){
        dfs(depth + 1, left, str+")");
        }
    }
    private static boolean checkValid(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty() || stack.peek() == ')') return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}