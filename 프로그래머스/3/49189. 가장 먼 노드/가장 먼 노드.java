import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<List<Integer>> relations = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            relations.add(new ArrayList<Integer>());
        }
        
        for(int[] ed : edge){
            int a = ed[0];
            int b = ed[1];
            relations.get(a).add(b);
            relations.get(b).add(a);
        }
        
        int[] dists = new int[n + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        pq.add(new int[]{1,0});
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(dists[now[0]] < now[1]) continue;
            
            for(int next: relations.get(now[0])){
                if(dists[next] > now[1] + 1){
                    dists[next] = now[1] + 1;
                    pq.add(new int[]{next, dists[next]});
                }
            }
        }
        
        int max = -1;
        int cnt = 0;
        for(int i = 2; i <= n; i++){
            if(dists[i] > max){
                max = dists[i];
                cnt = 1;
            }else if(max == dists[i]){
                cnt++;
            } 
        }
        
        int answer = cnt;
        return answer;
    }
}