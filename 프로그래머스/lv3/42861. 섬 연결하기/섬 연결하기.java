import java.util.*;
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[]o2){
                return Integer.compare(o1[2], o2[2]);
            }
        });
        
        int answer = 0;        
        for(int i = 0; i < costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    private void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA < rootB){
            parent[rootB] = rootA;
        }else{
            parent[rootA] = rootB;
        }
        
    }
    
    private int find(int child){
        if(parent[child] == child){
            return child;
        }
        return parent[child] = find(parent[child]);
    }
}