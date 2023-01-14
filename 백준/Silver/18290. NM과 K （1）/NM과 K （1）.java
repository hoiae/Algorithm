
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] numbers;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;
    static int M;
    static int K;
    static int sum = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numbers = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0);
        System.out.println(sum);
    }


    private static void dfs(int row, int col, int depth, int tempSum) {
        if (depth == K) {
            sum = Math.max(tempSum, sum);
            return;
        }
        for (int i = row; i < N; i++) {
            for (int j = ( i == row ? col : 0); j < M; j++) {
                if (!visit[i][j] && check(i,j)) {
                    visit[i][j] = true;
                    dfs(i, j, depth + 1, tempSum + numbers[i][j]);
                    visit[i][j] = false;
                }

            }
        }
    }

    private static boolean check(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if ((nr >= 0 && nr < N && nc >= 0 && nc < M) && (visit[nr][nc])) {
                return false;
            }
        }
        return true;
    }
}
