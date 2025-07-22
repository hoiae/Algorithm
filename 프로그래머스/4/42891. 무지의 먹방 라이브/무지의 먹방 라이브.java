import java.util.*;

class Solution {
    static class Food {
        int index;
        int time;

        public Food(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
    
    public int solution(int[] food_times, long k) {
        long total = 0;
        for (int time : food_times) {
            total += time;
        }
        if (total <= k) return -1;

        PriorityQueue<Food> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        int n = food_times.length;
        for (int i = 0; i < n; i++) {
            pq.add(new Food(i + 1, food_times[i]));
        }

        long prevTime = 0;
        long sum = 0;

        while (!pq.isEmpty()) {
            long now = pq.peek().time;
            long diff = now - prevTime;
            long consume = diff * pq.size();

            if (sum + consume > k) break;

            sum += consume;
            prevTime = now;
            while (!pq.isEmpty() && pq.peek().time == now) {
                pq.poll();
            }
        }

        List<Food> list = new ArrayList<>(pq);
        list.sort((a,b)-> a.index - b.index);
        return list.get((int)((k - sum) % list.size())).index;
    }

}
