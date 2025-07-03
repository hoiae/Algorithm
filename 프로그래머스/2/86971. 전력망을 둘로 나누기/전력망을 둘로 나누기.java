import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Set<Integer>> tree;
    public int solution(int n, int[][] wires) {
        
        //2개로 분할하고 그 차이가 최소가 되는 값을 return해라
        //트리 -> 이어저있다.
        
        //1. 트리를 만든다.
        tree = new ArrayList<>();
        for(int i = 0 ; i <= n; i++){
            tree.add(new HashSet<>());
        }
        
        for(int[] wire: wires){
            int n1 = wire[0];
            int n2 = wire[1];
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }
        
        int minDiff = Integer.MAX_VALUE;
        //1.wires의 하나의 구간을 끊는다. -> 1번 노드부터 탐색시작 DFS
        for(int[] wire: wires){
            int n1 = wire[0];
            int n2 = wire[1];
            
            tree.get(n1).remove(n2);
            tree.get(n2).remove(n1);
            //1번 노드부터 탐색
            visited = new boolean[n + 1];
            visited[1] = true;
            int cnt = dfs(1);
            minDiff = Math.min(minDiff, Math.abs(Math.abs(n - cnt) - cnt));
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }
        
        int answer = minDiff;
        return answer;
    }
    private int dfs(int node){
        int sum = 1;
        for(int next: tree.get(node)){
            if(visited[next]) continue;
            visited[next] = true;
            sum += dfs(next);
        }
        
        return sum;
    }
}