
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int s;
    static int[] arr;


    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (s == 0)
            cnt--;
        System.out.println(cnt);
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            if(sum == s)
                cnt++;
            return;
        }
        dfs(depth + 1 ,sum);
        dfs(depth + 1, sum + arr[depth]);

    }
}
