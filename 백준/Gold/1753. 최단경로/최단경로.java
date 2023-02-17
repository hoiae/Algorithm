
import java.io.*;
import java.util.*;

//백준 1753, 최단경로 - 다익스트라 알고리즘
public class Main {
    static int v, e, k;
    static List<info>[] map;
    static int[] distanceArr; //기준이되는 노드에서 (인덱스의) 다른노드까지; 최소 거리를 저장하기 위한 배열

    static class info implements Comparable<info> {
        int node;
        int distance;
        public info(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(info o) {
            return Integer.compare(distance, o.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        map = new ArrayList[v + 1];
        distanceArr = new int[v + 1];

        //경로가 존재하지 않는 경우에는 INF를 출력하기 위한 값
        Arrays.fill(distanceArr, Integer.MAX_VALUE);

        //map 초기화
        for (int i = 1; i <= v; i++) {
            map[i] = new ArrayList<info>();
        }
        // map에 u(출발) v(목표) w(가중치)저장.
        int u, v, w;
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map[u].add(new info(v, w));
        }
        findShortestPath(k);

        for (int i = 1; i < distanceArr.length; i++){
            if(distanceArr[i] == Integer.MAX_VALUE){
                bw.write("INF\n");
            }else {
                bw.write(distanceArr[i]+"\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void findShortestPath(int k) {
        PriorityQueue<info> pq = new PriorityQueue<>();
        distanceArr[k] = 0;
        pq.add(new info(k,0));

        while(pq.isEmpty() == false){
            info now = pq.poll();
            if(now.distance > distanceArr[now.node]){
                continue;
            }
            for(info next: map[now.node]){
                if(distanceArr[next.node] > distanceArr[now.node] + next.distance){
                    distanceArr[next.node] = distanceArr[now.node] + next.distance;
                    pq.add(new info(next.node, distanceArr[next.node]));
                }
            }
        }
    }
}
