import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int N, M, R;//지역 개수, 수색범위, 길의 개수
    static int[] items;
    static ArrayList<Info>[] map;
    static int[][] dists;
    static int max;

    static class Info {
        int city;
        int dist;

        public Info(int city, int dist) {
            this.city = city;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        init();
        solve();
        System.out.println(max);
    }

    private static void solve() {
        FloydWarshall();
        findMaxCountItem();
    }

    private static void findMaxCountItem() {
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (dists[i][j] <= M) {
                    sum += items[j];
                }
            }
            max = Math.max(max, sum);
        }
    }

    private static void FloydWarshall() {
        //각 도시간의 거리를 구함
//        //3중 포문 시작지점, 거처가는 지점, 도착지점.
//        //직선 거리를 먼저 채움
        for (int mid = 1; mid <= N; mid++) {
            for (int start = 1; start <= N; start++) {
                for (int end = 1; end <= N; end++) {
                    if (dists[start][end] > dists[start][mid] + dists[mid][end]) {
                        dists[start][end] = dists[start][mid] + dists[mid][end];
                    }
                }
            }
        }
//        for (int start = 1; start <= N; start++) {
//            for (int mid = 1; mid <= N; mid++) {
//                for (int end = 1; end <= N; end++) {
//                    if (mid == end) {
//                        continue;
//                    }
//                    if (dists[start][end] > dists[start][mid] + dists[mid][end]) {
//                        dists[start][end] = dists[start][mid] + dists[mid][end];
//                    }
//                }
//            }
//        }
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        items = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        dists = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dists[i][j] = 15 * 100 * 100 + 1;
                if (i == j) {
                    dists[i][j] = 0;
                }
            }
        }

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            map[a].add(new Info(b, dist));
            map[b].add(new Info(a, dist));

            dists[a][b] = dist;
            dists[b][a] = dist;
        }
    }
}
