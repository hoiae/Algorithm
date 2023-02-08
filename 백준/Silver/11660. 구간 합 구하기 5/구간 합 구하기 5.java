
import java.io.*;
import java.util.StringTokenizer;

//백준 11660번 구간 합 구하기 5
public class Main {
    static int n,m;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        dp = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] += dp[i-1][j] + dp[i][j-1] -dp[i-1][j-1] + map[i][j];
            }
        }
        int x1,y1,x2,y2,result;
        for(int i = 1; i <=m; i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            result = dp[x2][y2] + dp[x1-1][y1-1] -dp[x1-1][y2] -dp[x2][y1-1];
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
}
