import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] parents;

    static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Star implements Comparable<Star> {
        int node1;
        int node2;
        double dist;

        public Star(int node1, int node2, double dist) {
            this.node1 = node1;
            this.node2 = node2;
            this.dist = dist;
        }

        @Override
        public int compareTo(Star o) {
            return Double.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points[i] = new Point(x, y);
        }

        //포인트간 거리를 구한 뒤 저장함.
        List<Star> stars = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                double dist = calculateDist(points[i], points[j]);
                stars.add(new Star(i, j, dist));
            }
        }
        //정렬
        Collections.sort(stars);

        parents = new int[n];
        //union and find
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        double totalDist = 0;
        for (int i = 0; i < stars.size(); i++) {
            Star now = stars.get(i);
            if(find(now.node1) != find(now.node2)){
                union(now.node1, now.node2);
                totalDist += now.dist;
            }
        }

        System.out.println(totalDist);

    }

    private static void union(int node1, int node2) {
        int root1 = parents[node1];
        int root2 = parents[node2];

        parents[root1] = root2;
    }

    private static int find(int node) {
        if(parents[node] == node){
            return node;
        }

        return parents[node] = find(parents[node]);
    }

    private static double calculateDist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
