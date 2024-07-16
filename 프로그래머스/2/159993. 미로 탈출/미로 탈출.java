import java.util.*;

class Solution {
    /*
    -레버까지 방문 처리
    -레버 도착하는 순간 방문배열 초기화
    */
    static int[] start;
    static int[] lever;
    static int[] exit;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n,m;
    static int cnt;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        start = new int[2];
        lever = new int[2];
        exit = new int[2];
        for(int i = 0; i < n; i++){
            String line = maps[i];
            for(int j = 0; j < m; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
                
                if(map[i][j] == 'E'){
                    exit[0] = i;
                    exit[1] = j;
                }
                
                if(map[i][j] == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }
                
        if(bfs(start,lever) && bfs(lever,exit)){
            return cnt;
        }
        return -1;
    }
    private static boolean bfs(int[] begin, int[] end){
        visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{begin[0], begin[1], 0});
        visited[begin[0]][begin[1]] = true;
       
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0;  i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 'X'){
                    continue;
                }
                if(nx == end[0] && ny == end[1]){
                    cnt += now[2] + 1;
                    return true;
                }
                
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, now[2] + 1});
            }
        }
        //
        return false;
        
    }
}