import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        List<String> nums = new ArrayList<>();
        
        for(int number : numbers){
            nums.add(String.valueOf(number));
        }
        
        Collections.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
            
        });
        
        if(nums.get(0).equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String num : nums){
            sb.append(num);
        }
        
        return sb.toString();
        
    }
}