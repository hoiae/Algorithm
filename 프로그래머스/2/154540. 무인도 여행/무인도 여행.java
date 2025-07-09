import java.util.*;
class Solution {
    static boolean[][] visited;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static String[] maps;
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        this.maps = maps;
        
        visited = new boolean[n][m];
        List<Integer> days = new ArrayList<>();
        for(int i = 0;  i < n; i++){
            for(int j = 0;  j < m; j++){
                if(visited[i][j] == true || maps[i].charAt(j)=='X'){
                    continue;
                }
                days.add(bfs(i,j));
                
            }
        }
        
        // days.sort((o1,o2) -> {return o1-o2;});
        Collections.sort(days);
        if(days.size() == 0){
            return new int[]{-1};
        }
        
        int[] answer = days.stream().mapToInt(i -> i).toArray();

        return answer;
    }
    private static int bfs(int x, int y){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        
        int sum = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            sum +=  maps[now[0]].charAt(now[1]) - '0';
            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || maps[nx].charAt(ny)=='X')
                    continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
        return sum;
    }
}