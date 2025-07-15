import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalKinds = gemTypes.size();

        Map<String, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (right < gems.length) {
            window.put(gems[right], window.getOrDefault(gems[right], 0) + 1);
            right++;

            while (window.size() == totalKinds) {
                if (right - left < minLen) {
                    minLen = right - left;
                    answer[0] = left + 1; 
                    answer[1] = right;
                }

                // 왼쪽 줄이기
                window.put(gems[left], window.get(gems[left]) - 1);
                if (window.get(gems[left]) == 0) {
                    window.remove(gems[left]);
                }
                left++;
            }
        }

        return answer;
    }
}
