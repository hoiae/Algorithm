import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visit[i] = true;
            dfs(i, i, 0, 0);
        }

        System.out.println(min);
    }

    private static void dfs(int start, int now, int depth, int sum) {
        if (depth == n - 1) {
            if (arr[now][start] != 0) {
                sum += arr[now][start];
                min = Math.min(min, sum);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i] && arr[now][i] != 0) {
                visit[i] = true;
//                sum += arr[now][i];
                dfs(start, i, depth + 1, sum + arr[now][i]);
                visit[i] = false;
            }
        }
    }
}
