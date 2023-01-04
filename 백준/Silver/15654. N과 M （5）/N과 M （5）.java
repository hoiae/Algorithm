
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int[] arr;
    static int[] numbers;


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        numbers = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        dfs(N, M, 0);
        System.out.println(sb);
    }

    private static void dfs(int N, int M, int depth) {
        if (M == depth) {
            StringBuilder tempSb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                tempSb.append(arr[i]).append(" ");
            }
            sb.append(tempSb).append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = numbers[i];
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}