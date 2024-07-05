import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        map = new int[n + 1][n + 1];
        for(int i = 0;  i < m; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());
            map[big][small] = 1; //작은 것
            map[small][big] = 2; //큰 것
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                        continue;
                    }
                    if(map[i][k] == 2 && map[k][j] == 2){
                        map[i][j] = 2;
                        continue;
                    }

                }
            }
        }
        
        StringBuilder sb =new StringBuilder();
        for(int i = 1;  i <= n; i++){
            int cnt = 0;
            for(int j = 1;  j <= n; j++){
                if(map[i][j] == 0 && i != j){
                    cnt++;
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
        
   
    }
  
}
