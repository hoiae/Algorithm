import java.util.*;
import java.io.*;


class Solution {
    static int[] info;
    static int N;
    static ArrayList<Integer>[] map ;
    static boolean[] visited;
    static int S,W;
    static int ans;
    public int solution(int[] info, int[][] edges) {
        this.info =info;
        N = info.length;
        map = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0;  i < N; i++){
            map[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges){
            int parent = edge[0];
            int child = edge[1];
            map[parent].add(child);    
        }
   
        //노드,양,늑대
        List<Integer> nexts = new LinkedList<>();
        for(int next : map[0]){
            nexts.add(next);
        }
        dfs(0,1,0,nexts);
        return ans;
    }
    
    private static void dfs(int node, int s, int w, List<Integer> nexts){
        if(s <= w) return;
        
        ans = Math.max(ans,s);
        for(int next: nexts){
            List<Integer> temp = new LinkedList<>(nexts);
            temp.addAll(map[next]); //다음 경로 저장.
            temp.remove(Integer.valueOf(next));//자신의 노드 제외
            
            //다음 노드가 양인 경우
            if(info[next] == 0){
                dfs(next,s + 1, w, temp);
            }else{//늑대인 경우
                dfs(next, s, w + 1, temp);
            }            
        }
    }
    
}