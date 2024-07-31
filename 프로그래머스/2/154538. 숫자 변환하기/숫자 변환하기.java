import java.util.*;
class Solution {
    static int min;
    static Set<Integer> set;
    public int solution(int x, int y, int n) {
        min =  Integer.MAX_VALUE;
        set = new HashSet<>();    
        if(min == Integer.MAX_VALUE){
            min = -1;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,0});
        set.add(x);
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == y){
                return now[1];
            }
            int[] next = {now[0] * 3, now[0] * 2 , now[0] + n};
            for(int i = 0; i < 3; i++){
                if(set.contains(next[i]) || next[i] > y){
                    continue;
                }
                
                set.add(next[i]);
                q.add(new int[]{next[i], now[1] + 1});
            }
        }
        return min;
    }
}