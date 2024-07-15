import java.util.*;

class Solution {
    static boolean[][] visited;
    static char[][] map;
    static int n, m;
    static int[] start;
    static int[] end;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        //visited로 방문한 자리를 표기한다.
        //이동횟수를 지정한다.
        visited = new boolean[n][m];
        map = new char[n][m];
        start = new int[2];
        end = new int[2];
        for(int i = 0; i < n; i++){
            for(int j = 0;  j < m; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j]== 'R'){
                    start[0] = i;
                    start[1] = j;
                }
                
                if(map[i][j]== 'G'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        
        //bfs
        int answer = bfs();
        return answer;
    }
    private static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        int[] s = new int[]{start[0],start[1],0};
        q.add(s);
        int ans = -1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0; i < 4; i++){
                //각방향의 끝까지 간다.
                int nx = now[0];
                int ny = now[1];
                while(true){
                    if(nx + dx[i] < 0 ||  nx + dx[i] >= n || ny + dy[i] < 0 || ny + dy[i] >= m 
                       || map[nx + dx[i]][ny + dy[i]] == 'D'){
                        break;
                    }
                    nx += dx[i];
                    ny += dy[i];
                }
                //방문한 경우 종료
                if(visited[nx][ny]){
                  continue;   
                } 
                if(nx == end[0] && ny == end[1]){
                   return ans = now[2] + 1;
                }
                
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny,now[2] + 1});
                
            }
        }
        return ans;
    }
}