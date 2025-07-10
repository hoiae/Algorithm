import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        //회원 10일
        //회원에게 매일 한가지 제품 할인한다. 회원은 단 한개만 구매할 수있다.
        
        //원하는 제품, 수량을 할인하는 날짜에 맞춰 회원가입하려고한다.
        
        int n = discount.length;
        
        Map<String,Integer> counts = new HashMap<>();
        //zeros의 품목이 names의 길이와 동일해지면 종료
        
        //첫날부터 10일치를 계산한다.
        for(int i = 0; i < 10; i++){
            String goods = discount[i];
            int value = counts.getOrDefault(goods, 0) + 1;
            counts.put(goods,value);
            
        }
        
        int cnt = 0;
        //확인한번
        boolean flag = true;
        for(int i = 0; i < want.length; i++){
            if(counts.getOrDefault(want[i],0) >= number[i]){
                continue;
            }
            flag = false;
            break;
        }

        if(flag){
            cnt++;
        }
        
        //11일차씩부터 순차대로 계산하며 원하는 품목을 가진 날짜를 찾는다.
        for(int r = 10; r < n; r++){
            int l = r - 10;
            //l은 빼고
            counts.put(discount[l], counts.get(discount[l]) - 1);
    
            //r은 더한다.
            counts.put(discount[r], counts.getOrDefault(discount[r],0) + 1);
            //계산
            flag = true;
            for(int i = 0; i < want.length; i++){
                if(counts.getOrDefault(want[i],0) >= number[i]){
                    continue;
                }
                flag = false;
                break;
            }
            
            if(flag){
                cnt++;
            }
        }
        
        int answer = cnt;
        return answer;
    }
}