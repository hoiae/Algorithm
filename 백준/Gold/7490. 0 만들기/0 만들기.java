import java.io.*;
import java.util.*;

public class Main {
    static List<String> lists;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0;  i < t; i++){
            lists = new ArrayList<>();
            if(i != 0){
                sb.append("\n");
            }
            int n = Integer.parseInt(br.readLine());
            //끝나는 기준, 현재 숫자, 다음 값
            dfs(n, 2,"1");
            Collections.sort(lists);
            for(String str : lists){
                sb.append(str+"\n");
            }
        }
        System.out.println(sb);
    }
    private static void dfs(int n, int now, String op){
        if(now > n){
            //계산
            cal(op);
            return;
        }
        
        dfs(n, now + 1, op +"+"+ String.valueOf(now));
        dfs(n, now + 1, op +" "+ String.valueOf(now));
        dfs(n, now + 1, op +"-"+ String.valueOf(now));
    }
    
    private static void cal(String op){
        String str = op.replaceAll(" ","");
        StringTokenizer st = new StringTokenizer(str, "+|-", true);
        int result = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()){
            String now = st.nextToken().replaceAll(" ","");
            if(now.equals("+")){
                result += Integer.parseInt(st.nextToken());
            }else {
                result -= Integer.parseInt(st.nextToken());
            }
        }
        if(result == 0){
            lists.add(op);
        }
    }
    
}
