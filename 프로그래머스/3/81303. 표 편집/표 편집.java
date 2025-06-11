import java.util.*;

class Solution {
    class Info{
        int index;
        int up;
        int down;
        public Info(int index, int up, int down){
            this.index =index;
            this.up = up;
            this.down = down;
        }
    }
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] delete = new boolean[n];
        //어떤 자료구조를 사용할것인가
        //인덱스로 이동할 수 있어야한다. 단 건너뛰기가 가능해야한다.
        
        //자기 자리를 찾아서 들어가야한다.
        //stack은 delete를 저장하는 용도로 무조건 사용한다.
        //이때, 저장하는 값은 상단에 누가 있었는지를 기억해야한다. position
  
        for(int i = 0; i < n; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        //cmd
        Stack<Info> stack = new Stack<>();
        int pointer = k;
        
        for(int index = 0; index < cmd.length; index++){
            String command = cmd[index];
            if(command.equals("C")){
                delete[pointer] = true;
                int up = prev[pointer];
                int down = next[pointer];
                
                stack.push(new Info(pointer,up, down));

                if(down != -1)
                prev[down] = up;
                if(up != -1)
                next[up] = down;
                
                
                // 삭제 후 커서 이동
                if (down != -1) pointer = down;
                else pointer = up;

            }else if(command.equals("Z")){
                Info recovery = stack.pop();
                delete[recovery.index] = false;
                
                if(recovery.up != -1)
                next[recovery.up] = recovery.index;

                if (recovery.down != -1)
                prev[recovery.down] = recovery.index;
                
                // 추가로 자기 자신 기준으로도 연결 복원해야 함
                next[recovery.index] = recovery.down;
                prev[recovery.index] = recovery.up;
                
            }else if(command.charAt(0) == 'U'){
                int num = Integer.parseInt(cmd[index].split(" ")[1]);
                for(int i = 0; i < num; i++){
                     pointer = prev[pointer];
                }
            }else{
                int num = Integer.parseInt(cmd[index].split(" ")[1]);
                for(int i = 0; i < num; i++){
                     pointer = next[pointer];
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(!delete[i]){
                sb.append("O");
            }else{
                sb.append("X");
            }
        }
    
        String answer = sb.toString();
        return answer;
    }
}