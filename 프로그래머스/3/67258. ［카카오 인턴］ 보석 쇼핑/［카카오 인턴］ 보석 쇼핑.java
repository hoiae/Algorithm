import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        //set을 활용해 다른 원소의 개수를 파악한다.
        //슬라이딩 윈도우-개수가 다채워질 때 까지길이 늘림,
        //개수가 다 채워지면 길이 줄임
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        // for(int i = 0; i < gems.length; i++){
        //     set.add(gems[i]);
        // }
        
        //구성하는 보석의 종류
        int diffCnt = set.size();
        set.clear();
        HashMap<String,Integer> counts = new HashMap<>();
        
        //초기에 다른 보석을 모두 포함하는 구간을 찾음
        int left = 0;
        int right = -1;
        for(int i = 0; i <gems.length; i++){
            set.add(gems[i]);
            //해당 키가 없으면 1로
            if(counts.putIfAbsent(gems[i],1) != null){
                int value = counts.get(gems[i]);
                counts.put(gems[i],value + 1);
            }
            if(set.size() == diffCnt){
                right = i;
                break;
            }
        }
        
        int[] answer = new int[2];
        //슬라이딩 윈도우
        
        int minSize = Integer.MAX_VALUE;
        while(left <= right && right < gems.length){
            if(set.size() >= diffCnt){
                if(minSize > (right - left)){

                    minSize = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                //left의 해당하는 count를 --함.
                int value = counts.get(gems[left]);
                counts.put(gems[left], value - 1);

                //count가 0이 되면 set에서 remove한다.
                if(counts.get(gems[left]) == 0){
                    set.remove(gems[left]);
                }
                left++;
                continue;
            }
            
            if(set.size() < diffCnt){
                right++;
                if(right < gems.length){
                    int value = counts.get(gems[right]);
                    counts.put(gems[right], value + 1);
                    set.add(gems[right]);                
                }
                continue;
            }
        }
        return answer;
    }
}