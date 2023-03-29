import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
    
        Map<String,Integer> map = new HashMap<>();
        
        //clothes배열에 담긴 모든 값을 순차적으로 map에 담아야함
        //옷의 종류를 key로 하여 개수를 value에 담음
        for(int i = 0;  i < clothes.length; i++){
            String key = clothes[i][1];
            if(map.containsKey(key)){
                int value = map.get(key);
                map.put(key,value + 1);
            }
            else{
                map.put(key, 1);
            }
        }
        
        //map에 저장된 key의 value들끼리 값을 곱함
        int multi = 1;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println("key :" +entry.getKey() +" value : "+entry.getValue());
            int currValue = entry.getValue();
            multi *= currValue + 1;
        }
        
        
        return multi - 1;
    }
}