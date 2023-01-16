
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int sum = Integer.MIN_VALUE;
    static int[] arr;
    static int[] result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = new int[n];
        visit = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(sum);
    }

    private static void dfs(int depth) {
        if(depth == n){
            calculate();
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                result[depth] = arr[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    private static void calculate() {
        int temp = 0;
        for(int i = 2; i <= n; i++){
            temp +=  Math.abs(result[i-2] - result[i - 1]);
        }
        sum = Math.max(temp,sum);
    }
}
