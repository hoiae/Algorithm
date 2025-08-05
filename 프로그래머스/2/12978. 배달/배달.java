import java.util.*;

class Solution {
    static class Info{
        int node;
        int cost;
        
        public Info(int node, int cost){
            this.node = node;
            this.cost= cost;
        }
        
    }
    public int solution(int N, int[][] road, int K) {
        int[] dists = new int[N + 1];
        Arrays.fill(dists,Integer.MAX_VALUE);
        dists[1] = 0;
        
        List<Info>[] map = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            map[i] = new ArrayList<>();
        }
        
        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int cost = r[2];
            map[a].add(new Info(b,cost));
            map[b].add(new Info(a,cost));
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->
            a[1] - b[1]);
        
        pq.add(new int[]{1,0});
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(dists[now[0]] < now[1]) continue;
            
            for(Info next : map[now[0]]){
                if(dists[next.node] <= now[1] + next.cost) continue;
                dists[next.node] = now[1] + next.cost;
                pq.add(new int[]{next.node, dists[next.node]}); 
            }

        }
        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(dists[i] <= K) answer++;
        }
        return answer;
    }
}