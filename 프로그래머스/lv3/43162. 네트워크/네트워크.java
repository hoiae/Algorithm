import java.util.*;
class Solution {
    static ArrayList[] map;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        
        map = new ArrayList[n];
        for(int i = 0;  i < map.length; i++){
            map[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < computers.length; i++){
            int[] com = computers[i];
            for(int j = 0; j < com.length; j++){
                if(com[j] == 1){
                    map[i].add(j);
                }
            }
        }
        
        int answer = 0;
        for(int i = 0;  i < n; i++){
            System.out.println(Arrays.toString(visited));
            if(visited[i] == false){
                answer++;
                dfs(i);    
            }
        }
        return answer;
    }
    private void dfs(int node){
        ArrayList<Integer> currNode = map[node];
        for(int connectedNode:currNode){
            if(!visited[connectedNode]){
                visited[connectedNode] = true;
                dfs(connectedNode);
            }
        }
    }
}