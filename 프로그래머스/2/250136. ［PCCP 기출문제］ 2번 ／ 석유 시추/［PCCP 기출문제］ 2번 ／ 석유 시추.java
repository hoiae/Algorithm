import java.util.*;

class Solution {
    static boolean[][] visited; //방문처리
    static Map<Integer,Integer> groups; //그룹id, 크기
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;//가로, 세로
    static int[][] map;
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] land) throws Exception{
        n = land.length;
        m = land[0].length;
        map = land;
        groups = new HashMap<>();
        visited = new boolean[n][m];
        int index = 1;
        for(int i = 0;  i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] || map[i][j] != 1) continue;
                int count = bfs(i, j, ++index);
                //hashmap에 저장한다.
                groups.put(index, count);
            }
        }
        //1.bfs를 하며 그룹번호를 매긴다.
        //1-1.그룹별 크기를 지정한다. hashMap
        
        //i행 (i - 1로 접근해야함) 별로 속해있는 그룹을 찾아서 기록한다.
        //set사용 중복되는 그룹이 없도록 한다.
        int max = 0;
        for(int i = 0; i < m; i++){
            Set<Integer> container = new HashSet<>();
            for(int r = 0; r < n; r++){
                container.add(map[r][i]);
            }
            int size = 0;
            for(int groupNumber: container){
                if(groupNumber == 0) continue;
                size += groups.get(groupNumber);
            }
            max = Math.max(max,size);
        }
        int answer = max;
        return answer;
    }
    
    private static int bfs(int x, int y, int index){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;
        int cnt = 0;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            map[now.x][now.y] = index;
            cnt++;
            for(int i = 0;  i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] != 1)
                    continue;
                visited[nx][ny] = true;
                q.add(new Point(nx,ny));
            }
        }
        
        return cnt;
    }
}