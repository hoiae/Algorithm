

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static class Point{
        int x;
        int y;
        int cnt;
        public Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] ars) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t =  Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            sb.append(solve()).append("\n");
        }
        System.out.println(sb);
    }

    private static String solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        char[][] map = new char[h][w];
        Point startMan = null;

        Queue<Point> fq = new LinkedList<>();
        boolean[][] fired= new boolean[h][w];

        for(int i = 0; i < h; i++){
            String line = br.readLine();
            for(int j = 0; j < w; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == '@') {
                    startMan = new Point(i, j ,0);
                }
                if(map[i][j] =='*'){
                    fq.add(new Point(i,j,0));
                    fired[i][j] = true;
                }
            }
        }

            //사람이 경계 밖으로 나갈때 까지 or 이동이 불가능할때 까지
//        PriorityQueue<Point> pq = new PriorityQueue<>((o1,o2) -> o1.cnt - o2.cnt);
        Queue<Point> pq = new LinkedList<>();
        pq.add(startMan);
        boolean[][] visited = new boolean[h][w];
        visited[startMan.x][startMan.y] = true;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        int chance = fq.size();
        while(!pq.isEmpty()){
            //불번짐
            int size = fq.size();
            while(size-- > 0){
                Point fire = fq.poll();
                for(int dir = 0; dir < 4; dir++){
                    int nx = fire.x + dx[dir];
                    int ny = fire.y + dy[dir];
                    if(nx < 0 || nx >= h || ny < 0 || ny>= w){
                        continue;
                    }
                    if(fired[nx][ny]) continue;
                    fired[nx][ny] = true;

                    if(map[nx][ny] =='#'){
                        continue;
                    }
                    map[nx][ny] = '*';
                    fq.add(new Point(nx,ny,0));
                }
            }

            //사람이동 > 밖으로 나가거나 || 이동 불가시 종료
            size = pq.size();
            while(size-- > 0){
                Point now = pq.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    //탈출
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    return String.valueOf(now.cnt + 1);
//                        cnt = Math.min(cnt, now.cnt + 1);
//                        continue;
                    }
                    if (visited[nx][ny])
                        continue;
                    visited[nx][ny] = true;

                    if (map[nx][ny] == '#' || map[nx][ny] == '*') {
                        continue;
                    }
                    pq.add(new Point(nx, ny, now.cnt + 1));
                }
            }

        }
        return "IMPOSSIBLE";
    }
}
