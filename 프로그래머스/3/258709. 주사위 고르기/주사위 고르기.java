import java.util.*;

class Solution {
    static int maxWinCount = -1;
    static int[] answer;
    static boolean[] visited;
    static int[][] dice;
    public int[] solution(int[][] dice) {
        this.dice =dice;
        int n = dice.length;
        visited = new boolean[n];
        
        combination(0, 0, n, n / 2);
        return answer;
    }

    private void combination(int idx, int count, int n, int h) {
        if (count == h) {
            List<Integer> aIdx = new ArrayList<>();
            List<Integer> bIdx = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) aIdx.add(i);
                else bIdx.add(i);
            }

            List<Integer> aSum = getSumList(aIdx, dice);
            List<Integer> bSum = getSumList(bIdx, dice);
            Collections.sort(bSum);

            int win = 0;
            for (int a : aSum) {
                // bSum에서 a보다 작은 값 개수 세기 → 이긴 횟수
                win += lowerBound(bSum, a);
            }

            if (win > maxWinCount) {
                maxWinCount = win;
                answer = aIdx.stream().mapToInt(i -> i + 1).toArray();
            }
            return;
        }

        if (idx == n) return;

        visited[idx] = true;
        combination(idx + 1, count + 1, n, h);
        
        visited[idx] = false;
        combination(idx + 1, count, n, h);
    }

    private List<Integer> getSumList(List<Integer> diceIndices, int[][] dice) {
        List<Integer> result = new ArrayList<>();
        dfsSum(0, 0, diceIndices, dice, result);
        return result;
    }

    private void dfsSum(int idx, int sum, List<Integer> diceIndices, int[][] dice, List<Integer> result) {
        if (idx == diceIndices.size()) {
            result.add(sum);
            return;
        }

        int[] currentDie = dice[diceIndices.get(idx)];
        for (int num : currentDie) {
            dfsSum(idx + 1, sum + num, diceIndices, dice, result);
        }
    }

    // 이진 탐색, target보다 작은 값 개수 세기
    private int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
