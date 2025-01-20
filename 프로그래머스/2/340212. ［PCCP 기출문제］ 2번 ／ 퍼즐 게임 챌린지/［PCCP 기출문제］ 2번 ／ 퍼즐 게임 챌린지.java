class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1; // 숙련도는 최소 1부터 시작
        int right = 100_000; // diffs[i]의 최대값
        int answer = right;

        while (left < right) { // left == right가 될 때 종료
            int mid = (left + right) / 2;
            if (solve(diffs, times, mid, limit)) {
                answer = mid; // 가능한 경우 정답 갱신
                right = mid; // 더 낮은 숙련도를 탐색
            } else {
                left = mid + 1; // 더 높은 숙련도를 탐색
            }
        }
        return answer;
    }

    private boolean solve(int[] diffs, int[] times, int level, long limit) {
        long spend = times[0]; // 첫 번째 퍼즐 시간

        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                spend += times[i];
            } else {
                int count = diffs[i] - level; // 틀리는 횟수
                spend += (long) count * (times[i - 1] + times[i]); // 반복 시간
                spend += times[i]; // 마지막으로 문제를 푼 시간
            }

            if (spend > limit) return false; // 제한 시간 초과
        }
        return true;
    }
}
