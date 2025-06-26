import java.util.*;
class Solution {
    public String solution(long n, String[] bans) {
        //bans의 문자열을 전부 숫자로 변경한다.
        List<Long> bannedIndex = new ArrayList<>();
        for(String ban: bans){
            Long index = calculateIndex(ban);
            bannedIndex.add(index);
        }
        
        Collections.sort(bannedIndex);
        //n번 도달까지 몇개가 빠졌는지 확인한다.
        for(int i = 0; i < bannedIndex.size(); i++){
            if(bannedIndex.get(i) > n){
                break;
            }
            n++;
        }
        
        //n번째 숫자를 찾는다.
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            int remainder = (int)(n % 26);
            n /= 26;
            char c = (char)('a' + remainder);
            sb.append(c);
        }
        
        sb.reverse();
        String answer = sb.toString();
        return answer;
    }
    private long calculateIndex(String str){
        long index = 0;
        for (int i = 0; i < str.length(); i++) {
            index = index * 26 + ((str.charAt(i) - 'a') + 1);
        }
        return index;
    }
}