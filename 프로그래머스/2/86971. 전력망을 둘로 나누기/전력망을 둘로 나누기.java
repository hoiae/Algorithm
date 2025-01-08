import java.util.*;

class Solution {
    static boolean[] visited;
    static int[][] map;
    public int solution(int n, int[][] wires) {
        //인접리스트를 만든다. tree는 각 노드가 어느 노드와 연결되어있는지 나타낸다.
        map = new int[n + 1][n + 1];
        
        //wires를 기반으로 map(인접행렬)을 채운다.
        for(int i = 0 ;  i < wires.length; i++){
            int n1 = wires[i][0];
            int n2 = wires[i][1];
            
            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }
        
        //wires에서 순차적으로 선을 하나씩 제거한다.
        int min = Integer.MAX_VALUE;
        for(int[] relation: wires){
            int n1 = relation[0];
            int n2 = relation[1];
            
            map[n1][n2] = 0;
            map[n2][n1] = 0;
            
            visited = new boolean[n + 1];
            int count1 = count(n1, n);
            int count2 = n- count1;
            min = Math.min(min, Math.abs(count1 - count2));
            
            map[n1][n2] = 1;
            map[n2][n1] = 1;
            
        }
        
        return min;
    }
    private int count(int node, int n){
        visited[node] = true;
        int cnt = 1;
        //해당 노드에서 방문할 수 있는 모든 곳의 개수를 파악해야한다.
        for(int i = 1;  i <= n; i++){
            if(map[node][i] == 1 && !visited[i]){
                cnt += count(i, n);
            }
        }
        
        return cnt;
    }
    
}