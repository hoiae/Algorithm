import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            sb.append(solve(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

    private static String solve(String input) {
        Stack<Character>  stack= new Stack<>();

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '(' || c == '['){
                stack.push(c);
                continue;
            }

            if(c == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                   return "NO";
                }
            }else{
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else{
                    return "NO";
                }
            }
        }

        if(stack.size()==0){
            return "YES";
        }

        return "NO";
    }
}