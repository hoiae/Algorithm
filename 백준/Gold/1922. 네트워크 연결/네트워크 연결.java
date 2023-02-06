
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 1922, 네트워크 연결
public class Main {
    static class info implements Comparable<info> {
        int node1;
        int node2;
        int distance;

        public info(int node1, int node2, int distance) {
            this.node1 = node1;
            this.node2 = node2;
            this.distance = distance;
        }

        @Override
        public int compareTo(info o) {
            return Integer.compare(distance, o.distance);
        }
    }

    static int[] group;//
    static info[] list;// 간선 리스트
    static int n;//컴퓨터의 수 노드의 수
    static int m;//간선의 수
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        //순환을 막기 위한 배열 구현
        group = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            group[i] = i;
        }

        int node1, node2, distance;
        //간선리스트 구현
        list = new info[m + 1];
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());
            list[i] = new info(node1, node2, distance);
        }

        Arrays.sort(list,1,m + 1);//

        //간선은 노드의 개수 - 1
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            if (find(list[i].node1) != find(list[i].node2)) {
                union(list[i].node1, list[i].node2);
                result += list[i].distance;
                cnt++;
                if (cnt == n - 1)
                    break;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();

    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        group[rootB] = rootA;
    }

    private static int find(int num) {
        if (group[num] == num) {
            return num;
        } else {
            return group[num] = find(group[num]);
        }
    }
}
