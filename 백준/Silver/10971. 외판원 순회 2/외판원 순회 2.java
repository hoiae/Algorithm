
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] map;
    static boolean[]visited;
    static int min = Integer.MAX_VALUE;
    static int startNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[N];
        for(int i = 0; i  < N; i++) {
            visited[i] = true;
            startNode = i;
            dfs(i, 0, 0);
            visited[i] = false;
        }
        System.out.println(min);
    }

    private static void dfs(int node , int depth, int cost) {
        if (depth == N - 1) {
            if(map[node][startNode] == 0) return;
            min = Math.min(cost + map[node][startNode], min);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(map[node][i] != 0 && !visited[i]){
                visited[i] = true;
                dfs(i , depth + 1, cost + map[node][i]);
                visited[i] = false;
            }
        }
    }
}
