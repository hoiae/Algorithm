import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5 * cities.length;

        Deque<String> cache = new ArrayDeque<>(cacheSize);
        int time = 0;

        for (String raw : cities) {
            String city = raw.toLowerCase();

            if (cache.remove(city)) { // 이미 있으면 제거 후 맨 앞(최신)으로
                time += 1;            // hit 1
                cache.addFirst(city);
            } else {
                time += 5;            // miss 5
                if (cache.size() == cacheSize) cache.removeLast(); // LRU 제거
                cache.addFirst(city);
            }
        }
        return time;
    }
}
