
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준1717,집합의 표현 서로소(union and find)
public class Main {
    static int n, m;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1;  i <= n; i++){
            parent[i] = i;
        }

        int command = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (command == 0) {
                union(a, b);
            } else {
                compare(a, b);
            }
        }
        System.out.println(sb);
    }

    private static void compare(int a, int b) {
        if(find(a) == find(b)){
            sb.append("YES").append("\n");
        }
        else{
            sb.append("NO").append("\n");
        }
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[bRoot] = aRoot; //반대로 해도 무관함.
    }

    private static int find(int a) {
        if (parent[a] == a)
            return a;
        else {
            return parent[a] = find(parent[a]);
            //return find(parent[a]) -> 시간초과
        }

    }
}
