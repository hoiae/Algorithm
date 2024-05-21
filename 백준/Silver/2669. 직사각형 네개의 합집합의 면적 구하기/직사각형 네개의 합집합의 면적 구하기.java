import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[101][101];
        for(int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int r = x1 + 1; r <= x2; r++){
                for(int c = y1+1; c <=y2; c++){
                    map[r][c] = 1;
                }
            }
        }
        
        int ans = 0;
        for(int i = 0;  i<=100; i++){
            for(int j = 0; j<=100; j++){
                if(map[i][j]==1){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
