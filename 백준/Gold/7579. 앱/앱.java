
import java.io.*;
import java.util.StringTokenizer;

//백준 7579번 - 앱
public class Main {
    static int N, M, totalCost;
    static int[] m;
    static int[] c;
    static int[][] dp;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        m = new int[N + 1];
        c = new int[N + 1];
        visit = new boolean[N + 1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            m[i] = Integer.parseInt(st1.nextToken());//메모리
            c[i] = Integer.parseInt(st2.nextToken());//소모비용
            totalCost += c[i];
        }

        dp = new int[N + 1][totalCost + 1];// i번 앱까지 중, j 만큼의 비용을 사용하여 만들수 있는 가장 많은 메모리
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= totalCost; j++) {
                dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);//기초값 이게뭐노
                if(j - c[i] >= 0){
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - c[i]] + m[i]); //이전값 + 현재 확보한 메모리
                }
            }
        }
        int result = 0;
        for(int i = 1; i <= totalCost; i++){
            if(dp[N][i] >= M){
                result = i;
                break;
            }
        }
        bw.write(result+"\n");
        bw.flush();
        bw.close();

    }
}
