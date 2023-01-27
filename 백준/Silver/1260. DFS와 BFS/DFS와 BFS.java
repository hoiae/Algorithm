
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] visit;
    static int n;
    static int m;
    static int v;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //정점개수
        m = Integer.parseInt(st.nextToken()); //간선개수
        v = Integer.parseInt(st.nextToken()); //시작하는 정점의 번호

        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        //인접 행렬 만들기
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }

        dfs(v);
        sb.append("\n");
        Arrays.fill(visit,false); //boolean[]타입 visit의 모든 요소를 false로
        bfs(v);

        System.out.println(sb);
    }

    private static void dfs(int index) {
        visit[index] = true;
        sb.append(index).append(" ");
        for(int i = 1; i <= n; i++){
            if(map[index][i] == 1 && !visit[i]){
                dfs(i);
            }
        }
    }
    private static void bfs(int index) {
        queue.add(index);
        visit[index] = true;
        int currentNumber;
        while(!queue.isEmpty()){
            currentNumber = queue.poll();
            sb.append(currentNumber).append(" ");
            for(int i = 1; i <= n; i++){
                if(map[currentNumber][i] == 1 && !visit[i]){
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
