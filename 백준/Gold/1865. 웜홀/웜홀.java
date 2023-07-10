import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Info{
        int to;
        int cost;
        public Info(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

    }
    static List<Info>[] Map;
    static int[] Cost;
    static int TC,N,M,W;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TC = Integer.parseInt(br.readLine());

        for(int i = 0; i < TC; i++){
            solve(br,bw);
        }

        bw.flush();
        bw.close();
    }

    private static void solve(BufferedReader br,BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        Map = new ArrayList[N + 1];

        for(int i = 1; i <= N ; i++){
            Map[i] = new ArrayList<>();
        }

        //도로 정보 입력받음,양방향
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            Map[from].add(new Info(to,cost));
            Map[to].add(new Info(from,cost));
        }
        //웜홀 정보 입력받음.
        for(int i = 0; i < W; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            Map[from].add(new Info(to, -1 * cost));
        }


        for(int i = 1;  i<= N; i++){
            Cost = new int[N + 1];
            Arrays.fill(Cost,INF);
            Cost[i] = 0;
            setCostArray();
            boolean isCircle = checkIsCircle();

            if(isCircle){
                bw.write("YES"+"\n");
                return;
            }
        }
        bw.write("NO"+"\n");

    }

    private static boolean checkIsCircle() {
        for(int j = 1; j <= N; j++){
            if(Cost[j] == INF)
                continue;
            List<Info> list = Map[j];
            for(Info now : list){
                if(Cost[now.to] > Cost[j] + now.cost){
                    return true;
                }
            }
        }
        return false;
    }

    private static void setCostArray() {
        for(int i = 0; i < N - 1; i++){
            boolean isUpdate = false;
            for(int j = 1; j <= N; j++){
                if(Cost[j] == INF)
                    continue;
                List<Info> list = Map[j];
                for(Info now : list){
                    if(Cost[now.to] > Cost[j] + now.cost){
                        Cost[now.to] = Cost[j] + now.cost;
                        isUpdate = true;
                    }
                }
            }
            if(isUpdate == false){
                return;
            }
        }
    }
}
