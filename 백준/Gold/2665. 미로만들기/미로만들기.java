import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[]dx = {-1,1,0,0};
    static int[]dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        map = new char[n][n];
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = input.charAt(j);
            }
        }
        
        int ans = bfs();
        System.out.println(ans);
    }
    private static int bfs(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{ return o1[2] - o2[2]; });
        pq.add(new int[]{0,0,0});
        visited[0][0] = true;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]){
                    continue;
                }
                //다음칸이 블럭인 경우
                int add = 0;
                if(map[nx][ny] == '0'){
                    add = 1;
                }
                //마지막칸인 경우
                if(nx == n - 1 && ny == n - 1){
                    return now[2];
                }
                
                visited[nx][ny] = true;
                pq.add(new int[]{nx, ny, now[2] + add});
            }
        }
        return 0;
    }
}
