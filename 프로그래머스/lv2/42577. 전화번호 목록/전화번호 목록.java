import java.util.*;
class Solution {
    public static boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String val: phone_book){
            set.add(val);
        }
        
        for(String val : phone_book){
            for(int i = 1; i < val.length(); i++){
                if(set.contains(val.substring(0,i)))
                    return false;
            }
        }
        return true;
}
}