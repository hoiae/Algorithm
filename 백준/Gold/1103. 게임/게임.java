
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visit;

    static int[][] dp;
    static int n;
    static int m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        visit = new boolean[n][m];


        String temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine();
            for (int j = 0; j < m; j++) {
                if (temp.charAt(j) == 'H') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = temp.charAt(j) - '0';
                }
            }
        }

        visit[0][0] = true;
        solve(0, 0, 1);

        System.out.println(max);
    }

    private static void solve(int x, int y, int cnt) {
        if (dp[x][y] >= cnt) {
            return;
        }
        dp[x][y] = cnt;
        if (max < cnt) {
            max = cnt;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + map[x][y] * dx[i];
            int nextY = y + map[x][y] * dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (map[nextX][nextY] == -1) {
                    continue;
                }

                if (visit[nextX][nextY]) {
                    System.out.println(-1);
                    System.exit(0);
                }
                visit[nextX][nextY] = true;
                solve(nextX, nextY, cnt + 1);
                visit[nextX][nextY] = false;
            }
        }
    }

}
