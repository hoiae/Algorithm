import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] indegree;
    static List<Integer>[] priorities;
    static boolean[] visited;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init(br);

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
                visited[i] = true;


            }
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();
            bw.write(now + " ");
            for(int next: priorities[now]){
                indegree[next]--;
            }

            for(int i = 1; i <= n; i++){
                if(visited[i]) continue;
                if(indegree[i] == 0){
                    pq.add(i);
                    visited[i] = true;
                }
            }
        }

        bw.flush();
        bw.close();
    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        indegree = new int[n + 1];
        priorities = new List[n + 1];
        for (int i = 1; i <= n ; i++) {
            priorities[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //b의 진입차수를 올림
            indegree[b]++;

            //priorities
            priorities[a].add(b);
        }
    }
}
