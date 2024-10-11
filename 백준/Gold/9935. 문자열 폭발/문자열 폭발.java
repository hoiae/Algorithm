import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String boom = br.readLine();
        
        //폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.
        //stack에 문자열을 담는다. 
        //만약 boom.length보다 stack이크고, stack.peek()가 boom의 마지막 문자열과 같으면 하나씩 꺼낸다.
        //boom과 동일하면 버린다.
        //boom과 다르면 다시 넣는다.
        int n = boom.length();
        Stack<Character> stack = new Stack();
        for(char c : input.toCharArray()){
            stack.push(c);
            if(stack.peek() == boom.charAt(n - 1) && stack.size() >= n){
                Stack<Character> temp = new Stack<>();
                //뒤에서 부터 하나씩 거꾸로 비교한다.
                for(int j = 0; j < n; j++){
                    if(stack.peek() == boom.charAt(n - 1 - j)){
                        temp.push(stack.pop());
                        continue;
                    }
                    break;
                }
                //stack이 폭발문자열이 아닌 경우
                if(temp.size() != n){
                    while(!temp.isEmpty()){
                        stack.push(temp.pop());
                    }
                }
                
            }
        }
        
        if(stack.size() > 0){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;  i < stack.size(); i++){
                sb.append(stack.get(i));
            }
            System.out.println(sb.toString());
        }else{
            System.out.println("FRULA");
        } 
    
                
    }
}
