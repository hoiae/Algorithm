import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static List<Info>[] map;
    private static int[] costs;
    private static List<Integer> visited = new ArrayList<>();
    private static int start;
    private static int end;

    private static class Info implements Comparable<Info>{
        int city;
        int cost;
        List<Integer> history = new ArrayList<>();

        public Info(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //도시의 이동정보(목적지, 비용)담는 map 초기화
        map = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[from].add(new Info(to, cost));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st2.nextToken());
        end = Integer.parseInt(st2.nextToken());
        dijkstra();

        bw.write(costs[end] + "\n");
        bw.write(visited.size() + "\n");
        for (int i = 0; i <visited.size(); i++) {
            bw.write(visited.get(i)+" ");
        }
        bw.flush();
        bw.close();
    }

    private static void dijkstra() {
        costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        if(start == end){
            visited.add(start);
            return;
        }

        Queue<Info> q = new PriorityQueue<>();
        Info startCity = new Info(start, 0);
        startCity.history.add(start);
        q.add(startCity);
        while (!q.isEmpty()) {
            Info now = q.poll();
            if(now.cost > costs[now.city]) continue;
            for (Info next : map[now.city]) {
                if (costs[next.city] > costs[now.city] + next.cost) {
                    costs[next.city] = costs[now.city] + next.cost;

                    Info nextCity = new Info(next.city,costs[next.city]);
                    nextCity.history.addAll(now.history);
                    nextCity.history.add(next.city);

                    if(next.city == end){
                        visited = nextCity.history;
                    }
                    q.add(nextCity);
                }
            }
        }
    }
}
