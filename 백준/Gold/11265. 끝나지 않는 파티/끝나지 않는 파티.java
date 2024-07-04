import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        //각 관계 채우기
        long[][] map = new long[n][n];
        for(int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < n; c++){
                map[r][c] = Long.parseLong(st.nextToken());
            }
        }
        
        for(int mid = 0; mid < n; mid++){
            for(int s = 0; s < n; s++){
                for(int e = 0; e < n; e++){
                    if(s == e) continue;
                    if(map[s][e] > map[s][mid] + map[mid][e]){
                        map[s][e] = map[s][mid] + map[mid][e];
                    }
                }
            }
        }
        
        StringBuilder sb= new StringBuilder();
        for(int i = 0;  i < m; i++){
            st =new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            long time = Long.parseLong(st.nextToken());
            
            if(map[start][end] <= time){
                sb.append("Enjoy other party"+"\n");
            }else{
                sb.append("Stay here"+"\n");
            }
        }
        System.out.println(sb);
        
    }
}
