import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 3;
        for(int i = 2; i<=n; i++){
            dp[i]= (dp[i - 2] + 2 * dp[i - 1]) % 9901; 
        }
        System.out.println(dp[n]);
    }
}
