import java.util.*;

class Solution {
    static int[] intensity;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        intensity = new int[n + 1];
        List<int[]>[] pathList = new ArrayList[n+1];
        for(int i = 1; i < n +1 ; i++){
            pathList[i] = new ArrayList<>();
        }
        for(int[] path: paths){
            pathList[path[0]].add(new int[]{path[1],path[2]});
            pathList[path[1]].add(new int[]{path[0],path[2]});
            
        }
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        for(int i = 0; i < gates.length; i++){
            intensity[gates[i]] = 0; //출발점
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        for(int i = 0; i < gates.length; i++){
            pq.add(new int[]{gates[i], 0});
        }
        
        Set<Integer> summitSet = new HashSet<>();
        for(int summit : summits){
            summitSet.add(summit);
        }
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            if(intensity[now[0]] < now[1]){
                continue;
            }
            
            if(summitSet.contains(now[0])) continue;

            for(int[] next : pathList[now[0]]){
                int newIntensity = Math.max(now[1], next[1]);
                if (intensity[next[0]] > newIntensity) {
                    intensity[next[0]] = newIntensity;
                    pq.add(new int[]{next[0], newIntensity});
                }
            }
        }
        
        int top = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(summits); // 번호 작은 봉우리 우선
        for(int summit: summits){
            if(intensity[summit] < min){
                top = summit;
                min = intensity[summit];
            }
        }
        int[] answer = {top, min};
        return answer;
    }
}