
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int T;
  static int M, N, K;
  static int map[][];
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    T = Integer.parseInt(br.readLine());
    for(int i = 0; i < T; i++){
      bw.write(solve(br)+"\n");
    }
    bw.flush();
    bw.close();
  }

  private static int solve(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[M][N];
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
    }

    //bfs
    int cnt = 0;
    visited = new boolean[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (visited[i][j] == false && map[i][j] == 1) {
          cnt++;
          bfs(i, j);
        }
      }
    }
    return cnt;
  }

  private static void bfs(int x, int y) {
    Queue<Info> q = new LinkedList<>();
    q.add(new Info(x, y));

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    while (!q.isEmpty()) {
      Info now = q.poll();
      for (int i = 0; i < 4; i++) {
        int nextX = now.x + dx[i];
        int nextY = now.y + dy[i];
          if(nextX >=0 && nextX < M & nextY >=0 && nextY < N
          && !visited[nextX][nextY] && map[nextX][nextY] == 1){
            q.add(new Info(nextX, nextY));
            visited[nextX][nextY] = true;
          }
      }
    }
  }

  static class Info {

    int x;
    int y;

    public Info(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
