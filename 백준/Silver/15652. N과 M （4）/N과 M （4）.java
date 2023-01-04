
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(1, M, 0);
        System.out.println(sb);
    }

    private static void dfs(int n, int M, int depth) {
        if (M == depth) {
            StringBuilder tempSb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                tempSb.append(arr[i]).append(" ");
            }
            sb.append(tempSb).append("\n");
            return;
        }

        for (int i = n; i <= N; i++) {
            arr[depth] = i;
            dfs(i, M, depth + 1);
        }
    }
}
