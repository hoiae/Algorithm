class Solution {
    static boolean[][][] visited;
    static int ex, ey;
    static int n,m;
    static int k;
    static char[] dirs = {'d','l','r','u'};
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static String answer;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        //같은 격자 여러번 방문 가능
        //미로에서 타출한 경로를 문자열로 나타냈을 때, 문자열이 사전순으로 가장 빠른경로로 탈출해야함
        this.n = n;
        this.m = m;
        this.k = k;
        ex = r - 1;
        ey = c - 1;
        //.빈공간 ,s는 출발지점, e는 탈출지점
        visited = new boolean[n][m][k+1];
        
        findPath(x-1, y-1, 0, "");
        if(answer == null) return "impossible";
        return answer;
    }
    
    private void findPath(int x, int y, int depth, String history){
        if(answer != null) return;
        if(depth > k){
            return;
        }
        if(visited[x][y][depth]){
            return;
        }
        
        visited[x][y][depth] = true;
        if(x == ex && y == ey && depth == k){
            answer= history;
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny= y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                continue;
            }
            
            findPath(nx, ny, depth + 1, history + dirs[i]);
        }
    }
}