import java.util.*;
class Solution {
    static int[] distance; //노드까지의 걸리는 거리를 담음
    static Queue<Integer> q = new LinkedList<Integer>();
    static List<Integer>[] nodes;
    
    public int solution(int n, int[][] edge) {
        //다익스트라 알고리즘

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); //각 노드에 도달하는 거리를 최대로 채움

        nodes = new ArrayList[n + 1];
        
        for(int i = 0;  i <= n; i++){
            nodes[i] = new ArrayList<Integer>();
        }
        
        
        for(int[] ed : edge){
            nodes[ed[0]].add(ed[1]);
            nodes[ed[1]].add(ed[0]);
        }
        
        distance[1] = 0;
        q.add(1);
        while(!q.isEmpty()){
            int currentNode = q.poll();
            for(int nextNode : nodes[currentNode]){
                if(distance[currentNode] + 1 < distance[nextNode]){
                    distance[nextNode] = distance[currentNode] + 1;
                    q.add(nextNode);
                }
            }
        }
        
        Arrays.sort(distance);
        int target = distance[distance.length-2];
        int cnt = 0;
        for(int dis : distance){
            if(dis == target)
                cnt++;
        }
        
        return cnt;
    }
}