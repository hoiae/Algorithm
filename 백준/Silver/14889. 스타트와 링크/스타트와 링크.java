
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
        //N은 짝수
        //2팀은 N/2로 인원구성
        //Sij = i사람 j사람이 같은팀에 속했을 대 팀에 더해지는 능력치
        //Sij Sji는 다를 수 있다. S의 합은 팀의 능력치이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        numbers = new int[N][N];
        visit = new boolean[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0,0);
        System.out.println(min);
    }

    private static void solve(int index, int depth) {
        if(depth == N/2){
            calculate();
            return;
        }

        for(int i = index; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                solve(i + 1 , depth + 1);
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
