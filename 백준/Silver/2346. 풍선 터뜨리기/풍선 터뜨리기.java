import java.io.*;
import java.util.*;

public class Main {
    static class Info{
        int index;
        int move;
        public Info(int index, int move){
            this.index = index;
            this.move = move;
        }
        public String toString(){
            return "index= "+index+", move= "+move; 
        }
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Deque<Info> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            q.add(new Info(i+1, Integer.parseInt(st.nextToken())));
        }
        
        StringBuilder sb = new StringBuilder();
        //처음 값부터 시작
        while(q.size() > 1){
            Info now = q.poll();
            sb.append(now.index+" ");
            //move가 양수인 경우 -> q의 앞에서부터 뒤로 넘김
            if(now.move > 0){
                for(int i = 0; i < now.move - 1; i++){
                    q.add(q.pollFirst());
                }
            //move가 음수인 경우 -> 뒤에서부터 앞으로 넘김
            }else{
                for(int i = 0; i < -now.move ; i++){
                    q.addFirst(q.pollLast());
                }
            }
        }
        sb.append(q.poll().index+" ");
        System.out.println(sb);
    }
}
