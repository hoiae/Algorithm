import java.io.*;
import java.util.*;

public class Main {
    static int r,c,k;
    static boolean[][] visited;
    static char[][] map;
    static int Cnt;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new char[r][c];
        for(int i = 0; i < r; i++){
            String input = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = input.charAt(j);
            }
        }
        
        visited = new boolean[r][c];
        visited[r-1][0] = true;
        dfs(r - 1, 0, 1);
        System.out.println(Cnt);
    }
    private static void dfs(int x, int y, int cnt){
        if(x == 0 && y == c-1){
            // System.out.println(x+", y="+y+", cnt="+cnt);
            if(cnt == k){
                Cnt++;
            }
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
             if(nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny] || map[nx][ny] == 'T')
            continue;
            visited[nx][ny] = true;
            dfs(nx,ny,cnt + 1);
            visited[nx][ny] = false;    
         }
    }
    // private static void bfs(int x, int y){
        // visited = new int[r][c];
        // Queue<int[]> q = new LinkedList<>();
        // q.add(new int[]{x,y,1});
        // visited[x][y] = true;
        
        // int cnt = 0;
        // int[] dx = {-1,1,0,0};
        // int[] dy = {0,0,-1,1};
        // while(!q.isEmpty()){
            // int[] now = q.poll();
            // for(int i = 0; i < n; i++){
                // int nx = now[0] + dx[i];
                // int ny = now[1] + dy[i];
                // if(nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny] || map[nx][ny] == 'T')
                // continue;
                // if(nx == 0 && ny == c - 1){
                    // if(now[2] + 1 == k){
                        // cnt++;
                    // }
                    // continue; 
                // }
            // }
        // }
    // }
}
