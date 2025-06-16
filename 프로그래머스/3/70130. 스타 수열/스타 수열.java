import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int answer = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : a){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        
        for(int key : map.keySet()){
            if(map.get(key) * 2 <= answer){
                continue;
            }
            int cnt = 0;
            for(int i = 0; i < n - 1; i++){
                if(a[i] != a[i+1] && (a[i] == key || a[i+1] == key)){
                    cnt++;
                    i++;
                }
            }
            answer = Math.max(answer, cnt * 2);
        }
       
        return answer;
    }
}