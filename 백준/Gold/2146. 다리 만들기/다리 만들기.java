import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int n;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for(int i =0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //1.그룹나누기
        int groupNumber = 2;
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    makeGroupNumber(i,j,groupNumber++, visited);
                }
            }
        }
        //2.그룹별 방문그룹만들기
        boolean[] usedGroup = new boolean[groupNumber];//2부터 유요함
        
        int minDist = Integer.MAX_VALUE;
        //3.그룹별 pq를 활용한 최소거리 측정
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] > 1 && !usedGroup[map[i][j]]){
                    usedGroup[map[i][j]] = true;
                    minDist = Math.min(findPath(i,j), minDist);
                }
            }
        }
        System.out.println(minDist);
    }
    private static int findPath(int sx, int sy){
        int currentGroup = map[sx][sy];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[2] - o2[2]);
        pq.add(new int[]{sx,sy,0});
        
        boolean[][] visited =new boolean[n][n];
        visited[sx][sy] = true;
        
        int minDist = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(isOutOfRange(nx,ny) || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;

                //다음칸이 동일한 그룸 -> 큐에 넣음 dist 추가 x
                if(map[nx][ny] == currentGroup){
                    pq.add(new int[]{nx,ny,dist});
                }
                //다음칸이 0 -> 큐에넣음
                else if(map[nx][ny] == 0){
                    pq.add(new int[]{nx,ny,dist+1});
                }
                //다음칸이 다른 그룹 -> 종료
                else{
                    minDist = Math.min(minDist, dist);
                }
                
            }
        }
        return minDist;
    }
    private static void printMap(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void makeGroupNumber(int sx, int sy, int groupNumber, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx,sy});
        visited[sx][sy] = true;
        map[sx][sy] = groupNumber;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(isOutOfRange(nx,ny) || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                
                if(map[nx][ny] == 1){
                    map[nx][ny] = groupNumber;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        
    }
    private static boolean isOutOfRange(int x, int y){
        if(x < 0 || x >=n || y < 0 || y >= n){
            return true;
        }
        return false;
    }
}
