
import java.io.*;

//백준 9252번 - LCS 2
public class Main {
    static int[][] direction;
    static int[][] dp;
    static String str1;
    static String str2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        str1 = br.readLine();
        str2 = br.readLine();

        final int cross = 1;
        final int up = 2;
        final int left = 3;

        dp= new int[str1.length() + 1][str2.length() + 1];
        direction = new int[str1.length() + 1][str2.length() + 1];
        //dp을 만들기
        for(int i = 1; i<=str1.length(); i++){
            for(int j = 1; j<=str2.length(); j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    direction[i][j] = cross;
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else if(dp[i - 1][j] > dp[i][j - 1]){
                    direction[i][j] = up;
                    dp[i][j] = dp[i - 1][j];

                }else {
                    direction[i][j] = left;
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        for(int i = str1.length(),j = str2.length(); i >= 1 && j>= 1; ){
            if(direction[i][j] == cross){
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            }else if(direction[i][j] == left){
                j--;
            }else if(direction[i][j] == up){
                i--;
            }
        }

        bw.write(dp[str1.length()][str2.length()]+"\n");
        bw.write(sb.reverse()+"");
        bw.flush();
        bw.close();
    }
}
