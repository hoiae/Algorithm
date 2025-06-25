import java.util.*;

class Solution {
    static int[][] dp;
    static List<List<Integer>> nodes;
    static boolean[] visited;
    
    public int solution(int n, int[][] lighthouse) {
        nodes = new ArrayList<>();
        dp = new int[n+1][2];
        visited = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            nodes.add(new ArrayList<>());
        }
        
        for(int[] light : lighthouse){
            int one = light[0];
            int theOther = light[1];
            
            nodes.get(one).add(theOther);
            nodes.get(theOther).add(one);
        }
        
        //연결된 노드의 개수로 정렬한다.
        visited[1] = true;
        dfs(1);

        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    private void dfs(int node){
        dp[node][0] = 0;
        dp[node][1] = 1;
        
        for(int next: nodes.get(node)){
            if(visited[next]) continue;
            visited[node] = true;
            dfs(next);
            dp[node][0] += dp[next][1];
            dp[node][1] += Math.min(dp[next][0], dp[next][1]);
        }
        
    }
}