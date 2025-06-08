import java.util.*;

class Solution {

    public int solution(int[][] board) {
        //직선도로 100원, 곡선도로는 500원
    
        //우측하단으로 도달하는데 필요한 최소비용을 계산해야한다
        return dijkstra(board,0,0);    
    }
    
    private static int dijkstra(int[][] board, int sx, int sy){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return o1[3] - o2[3];
        });
        
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        int n = board.length;
        int[][][] visited = new int[n][n][4];
        for(int i = 0;  i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        for(int i = 0; i < 4; i++){
            pq.add(new int[]{sx,sy,i,0});
            // visited[sx][sy][i] = 0;
        }
        
        int minPrice = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            // System.out.println("x="+now[0]+", y="+ now[1] + ", dir="+ now[2]+", cost="+now[3]);
            if(now[0] == n-1 && now[1] == n - 1){
                minPrice = now[3];
                break;
            }
            for(int dir = 0; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1){
                    continue;
                }
                
                int nextPrice = now[3] + (dir == now[2] ? 100 : 600);
                if(visited[nx][ny][dir] < nextPrice){
                    continue;
                }
                visited[nx][ny][dir] = nextPrice;
                pq.add(new int[]{nx,ny,dir,nextPrice});
              
            }
        }
        return minPrice;
    }
}