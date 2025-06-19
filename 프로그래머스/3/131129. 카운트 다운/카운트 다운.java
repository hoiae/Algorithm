import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[] dp = new int[target + 1];          // 최소 횟수
        int[] cnt = new int[target + 1];         // 싱글+불 횟수
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        Set<Integer> scores = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            scores.add(i);       // 싱글
            scores.add(i * 2);   // 더블
            scores.add(i * 3);   // 트리플
        }
        scores.add(50);          // 불

        for (int i = 1; i <= target; i++) {
            for (int score : scores) {
                if (i - score >= 0 && dp[i - score] != Integer.MAX_VALUE) {
                    int newCnt = cnt[i - score];
                    if (score <= 20 || score == 50) newCnt++; // 싱글/불일 때만 cnt++

                    if (dp[i - score] + 1 < dp[i]) {
                        dp[i] = dp[i - score] + 1;
                        cnt[i] = newCnt;
                    } else if (dp[i - score] + 1 == dp[i]) {
                        cnt[i] = Math.max(cnt[i], newCnt);
                    }
                }
            }
        }

        return new int[]{dp[target], cnt[target]};
    }
}
