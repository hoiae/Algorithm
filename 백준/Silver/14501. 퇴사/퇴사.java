
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] t;
    static int[] p;
    static int max = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        getMax(0,0);
        System.out.println(max);
    }
    private static void getMax(int cnt, int sum) {
        if(cnt > n) return;
        if(cnt == n){
            max = Math.max(sum,max);
            return;
        }
        getMax(cnt + t[cnt],sum + p[cnt]);
        getMax(cnt + 1, sum);
    }
}
