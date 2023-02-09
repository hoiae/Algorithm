
import java.io.*;

//백준5582 - 공통 부분 문자열
public class Main {
    static String str1;
    static String str2;
    static int[][] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str1 = br.readLine(); //행
        str2 = br.readLine(); //열

        dp = new int[str1.length()+1][str2.length()+1];
        for(int i = 1; i <=str1.length(); i++){
            for(int j = 1; j<=str2.length(); j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1] + 1);
                    max = Math.max(dp[i][j],max);
                }
            }
        }

        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}
