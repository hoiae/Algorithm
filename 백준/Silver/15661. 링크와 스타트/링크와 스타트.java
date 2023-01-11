
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] numbers;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        numbers = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
        System.out.println(min);
    }

    private static void solve(int index, int depth) {
        if(depth == N - 1){
            return;
        }
        for(int i = index; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                calculate();
                solve(i + 1, depth  + 1);
                visit[i] = false;
            }
        }
    }

    private static void calculate() {
        int start = 0;
        int link = 0;

        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                if(visit[i] == true && visit[j] == true){
                    start += numbers[i][j];
                    start += numbers[j][i];
                }
                if(visit[i] == false && visit[j] == false){
                    link += numbers[i][j];
                    link += numbers[j][i];
                }
            }
        }
        min = Math.min(min,Math.abs(start - link));
    }
}