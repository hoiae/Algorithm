import java.util.*;
class Solution {
    static Map<String,String> parents;
    static Map<String,Integer> money;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        parents = new HashMap<>();
        money = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++){
            String name = enroll[i];
            String ref = referral[i];
            parents.put(name,ref);
            money.put(name,0);
        }
        money.put("-",0);
        
        for(int i = 0; i < seller.length; i++){
            String name = seller[i];
            int benefit = amount[i] * 100;
            //부모가 존재하면 0.1프로의 금액을 계속 올린다.
            //만약 0.1프로가 1미만이면 넘기지 않는다.
            cal(name, benefit);
        }
                
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            String name = enroll[i];
            answer[i] = money.get(name);
        }
        return answer;
    }
    
    private static void cal(String name, int benefit){
        int parentBenefit = (int)(benefit * 0.1);
        //부모한테 돈을 안줘도 되는 경우
        if(parentBenefit < 1 || !parents.containsKey(name)){
            int value = money.get(name);
            money.put(name,value + benefit);
        }else{
        //부모한테 돈을 줘야하는 경우
            int value = money.get(name);
            money.put(name, value + (benefit - parentBenefit));
            String parent = parents.get(name);
            cal(parent, parentBenefit);
        }
    }
}