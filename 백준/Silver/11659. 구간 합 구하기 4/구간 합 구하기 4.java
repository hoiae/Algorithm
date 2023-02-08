
import java.io.*;
import java.util.StringTokenizer;

//백준 11659- 구간합 구하기4
public class Main {
    static int n,m;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        dp = new int[n + 1];

        //배열입력 받음
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1] + arr[i]; //1부터 i번째 인덱스까지의 합을 저장함.
        }
        
        int a,b,result;
        for(int i = 1; i <=m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            result = dp[b] - dp[a - 1];
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
    }
}
