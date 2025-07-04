import java.util.*; 

class Solution {
    static Map<String,Integer>[] counts;
    static boolean[] visited;
    public String[] solution(String[] orders, int[] course) {
        //1.orders배열을 정렬한다.
    
        //2.조합의 개수를 파악한다.
        //만들수 있는 가짓수의 조합을 모두 구한다.
        
        counts = new HashMap[21];
        for(int i = 1; i <=20; i++){
            counts[i] = new HashMap<>();
        }
        
        for(String order: orders){
            char[] alphabets = order.toCharArray();
            Arrays.sort(alphabets);
            dfs(0,alphabets,"");
        }
        
        List<String> list = new ArrayList<>();
        int index = 0;
        for(int size: course){
            
            int maxCnt = 0;
            for(String key: counts[size].keySet()){
                if(counts[size].get(key) >= 2){
                    maxCnt = Math.max(maxCnt, counts[size].get(key));
                }
            } 
            
            for(String key: counts[size].keySet()){
                if(counts[size].get(key) == maxCnt){
                    list.add(key);
                }
            }   
        }
        Collections.sort(list);
        String[] ans = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    private static void dfs(int depth, char[] as, String str){
        if(depth == as.length){
            //추가
            int length = str.length();
            if(length == 0) return;
            
            int value =  counts[length].getOrDefault(str, 0);
            counts[length].put(str,value + 1);
            return;
        }
        
        //선택x
        dfs(depth + 1, as, str);
        
        //선택o
        dfs(depth + 1, as, str + String.valueOf(as[depth]));
        
        
    }
}