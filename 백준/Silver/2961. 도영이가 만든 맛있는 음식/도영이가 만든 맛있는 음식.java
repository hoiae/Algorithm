
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] s,b;
    static int n;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        s = new int[n];
        b = new int[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        dfs(0, 1, 0);

        System.out.println(min);
    }
    private static void dfs(int depth, long multiple, long sum){
        if(depth > 0){
            min = Math.min(min, (int)Math.abs(multiple - sum));
        }
        if(depth == n){
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                visited[i] = true;
                dfs(depth + 1, multiple * s[i], sum + b[i]);
                visited[i] = false;
            }
        }

    }


}
