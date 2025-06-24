import java.util.*;

class Solution {
    static List<List<Integer>> tree;
    static int[] a;
    static long cnt;
    static boolean[] visited;
    public long solution(int[] a, int[][] edges) {
        int n = a.length;
        cnt = 0;
        this.a = a;
        tree = new ArrayList<>();
        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }
        
        //1.edges를 사용해서 트리를 만든다.
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        
        //2.루트 노드를 찾는다.0번 노드를 root node로 지정한다.
        //3.dfs를 사용해서 리프노드에 도달하면, 해당노드부터 상위노드로 값을 계산해서 올린다.
        visited = new boolean[n];
        visited[0] = true;
        long answer = dfs(0);
    
        if(answer == 0){
            return cnt;
        }
        return -1;
    }
    private long dfs(int node){
        long total = 0;
        for(int i = 0 ; i < tree.get(node).size(); i++){
            int next = tree.get(node).get(i);
            if(visited[next]) continue;
            visited[next] = true;
            total += dfs(next);
        }

        cnt += Math.abs(a[node] + total);
        return total + a[node];
    }
}