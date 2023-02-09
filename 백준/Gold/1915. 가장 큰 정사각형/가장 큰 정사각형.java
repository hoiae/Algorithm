
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] map;
    static int n, m, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        //map채우기
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1) {
                    int left = dp[i][j - 1];
                    int up = dp[i - 1][j];
                    int cross = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(Math.min(left, up), cross) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        bw.write(max * max + "");
        bw.flush();
        bw.close();

    }
}
