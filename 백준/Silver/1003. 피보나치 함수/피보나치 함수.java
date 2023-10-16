import java.io.*;

public class Main {
    static int[][] dp = new int[40 + 1][2];
    static int cnt0;
    static int cnt1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        //dp채우기
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 2;  i <= 40; i++){
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for(int i = 0; i < t; i++){
            int num = Integer.parseInt(br.readLine());
            bw.write(dp[num][0] + " "+dp[num][1] +"\n");
        }

        bw.flush();
        bw.close();
    }

}
