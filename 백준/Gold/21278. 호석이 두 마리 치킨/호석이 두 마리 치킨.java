import java.util.*;
import java.io.*;

public class Main {
    static int[] dists;
    static int[][] betweens;
    static List<Integer>[] relations;
    static int n,m;
    static int ch1,ch2, minDist;
    static class Point implements Comparable<Point>{
        int city;
        int cost;
        
        public Point(int city, int cost){
            this.city = city;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Point o){
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        relations = new List[n + 1];
        for(int i = 0; i <= n; i++){
            relations[i] = new ArrayList<>();
        }
        
        for(int i = 0;  i < m; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relations[a].add(b);
            relations[b].add(a);
        }
        
        betweens = new int[n+1][n+1];
        //다익스트라로 각 도시로부터 최단 거리를 구한다.
        for(int i = 1;  i <= n; i++){
            dijkstra(i);
            // printTest(i);
        }
        
        
        //모든 도시의 2가지 조합을 구한다.
            //모든 도시에서 2가지 도시중 더 가까운 거리를 구한다.
            //갱신한다.
        minDist = Integer.MAX_VALUE;
        for(int i = 1;  i < n + 1 - 1; i++){
            for(int j = i + 1; j < n + 1; j++){
                check(i,j);
            }
        }
        System.out.println(ch1+" "+ch2+" "+(minDist * 2));
    }
    private static void check(int node1, int node2){
        int distSum = 0;
        for(int i = 1; i < n + 1; i++){
            if(i == node1 || i == node2) continue;
            distSum += Math.min(betweens[i][node1], betweens[i][node2]);
        }
        if(distSum < minDist){
            minDist = distSum;
            ch1 = node1;
            ch2 = node2;
        }
    }
    private static void printTest(int city){
        System.out.println("city=" + city+" 번 도시");
        System.out.println(Arrays.toString(betweens[city]));
    }
    private static void dijkstra(int startCity){
        //dists배열 초기화
        dists = new int[n + 1];
        Arrays.fill(dists,Integer.MAX_VALUE);
        dists[startCity] = 0;
        
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(startCity, 0));//현재가 될 도시와, 현재까지 이동거리
        
        while(!pq.isEmpty()){
            Point now = pq.poll();
            if(now.cost > dists[now.city]){
                continue;
            }
            for(int nextCity : relations[now.city]){
                if(now.cost + 1 < dists[nextCity]){
                    dists[nextCity] = now.cost + 1;
                    pq.add(new Point(nextCity, now.cost + 1));
                }
            }
        }
        //최단 거리를 betweens에 표기한다.
        for(int i = 1; i < n + 1; i++){
            betweens[startCity][i] = dists[i];
        }
    }
}
