import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] Map;
    private static int CheeseCnt;

    public static void main(String[] args) throws IOException {
    
        init();
        int hour = 0;
        while (CheeseCnt > 0) {
            bfs();
            hour++;
        }
        System.out.println(hour);
    }

    private static void bfs() {
        boolean[][] visited = new boolean[N][M];
        int[][] cheeses = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (Map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    } else {
                        cheeses[nx][ny]++;
                    }
                }
            }
        }
        //cheeseCnt 가 2이상인 경우 맵에서 0으로 변경함.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(cheeses[i][j] >= 2){
                    CheeseCnt--;
                    Map[i][j] = 0;
                }
            }
        }


    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        Map = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.parseInt(st2.nextToken());
                if (Map[i][j] == 1) {
                    CheeseCnt++;
                }
            }
        }
    }
}
