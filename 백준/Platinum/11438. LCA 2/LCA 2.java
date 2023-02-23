
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visit;
    static int[] depth;
    static int[][] parent;
    static int maxDepth;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        //인접리스트 구현
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        //maxDepth구하기
        int temp = 1;
        while (temp < n) {
            temp *= 2;
            maxDepth++;
        }
        //bfs를 통해서 각노드의 depth와 parent를 구함
        visit = new boolean[n + 1];
        depth = new int[n + 1];
        parent = new int[maxDepth + 1][n + 1];
        bfs(1);
        //점화식을 통한 parent배열 초기화 *****
        for(int i = 1; i <= maxDepth; i++){
            for(int j = 1; j<=n; j++){
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }

        //lca실행
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = getLCA(a,b);
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();

    }

    private static int getLCA(int a, int b) {
        //노드 a의 깊이가 더 크게 설정함
        if(depth[a] < depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        //두노드의 차이를 고려하여 부모 노드로 이동함
        for(int i = maxDepth; i >=0; i--){
            if(Math.pow(2,i) <= depth[a] - depth[b]){
                a = parent[i][a];
            }
        }

        //두 노드을 동일한 크기만큼 부모 노드로 이동시키면서 값을 비교함
        for(int i = maxDepth; i>=0; i--){
            if(parent[i][a] != parent[i][b]){
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        //**
        int LCA = a;
        if(a != b){
            LCA = parent[0][LCA];
        }
        return LCA;
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visit[node] = true;
        int level = 1;
        int nodeSize = 1;
        int count = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : tree[now]) {
                if(!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    parent[0][next] = now;
                    depth[next] = level;
                }
            }
            count++;
            if(count == nodeSize){
                count = 0;
                nodeSize = q.size();
                level++;
            }

        }
    }
}
