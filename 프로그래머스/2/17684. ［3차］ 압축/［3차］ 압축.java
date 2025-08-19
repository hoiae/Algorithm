import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)('A' + i)), i + 1);
        }

        List<Integer> result = new ArrayList<>();
        int index = 27;

        for (int i = 0; i < msg.length(); i++) {
            for (int j = i + 1; j <= msg.length(); j++) {
                String now = msg.substring(i, j);

                if (!map.containsKey(now)) {
                    String prev = msg.substring(i, j - 1);
                    result.add(map.get(prev));          
                    map.put(now, index++);                
                    int prevLen = (j - 1) - i;           
                    i += prevLen - 1;                     
                    break;
                }

                //마지막 토큰 출력
                if (j == msg.length()) {
                    result.add(map.get(now));
                    int nowLen = j - i;
                    i += nowLen - 1;
                    break;
                }
            }

        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
