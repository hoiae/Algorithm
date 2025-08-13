import java.util.*;

class Solution {
    class Work {
        String name;
        int remain;

        public Work(String name, int remain) {
            this.name = name;
            this.remain = remain;
        }
    }

    public String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();
        Stack<Work> stack = new Stack<>();

        // 시간을 분 단위로 변환
        for (String[] plan : plans) {
            String[] time = plan[1].split(":");
            int minutes = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            plan[1] = String.valueOf(minutes);
        }

        // 시작 시간 기준 정렬
        Arrays.sort(plans, Comparator.comparingInt(p -> Integer.parseInt(p[1])));

        for (int i = 0; i < plans.length - 1; i++) {
            String name = plans[i][0];
            int start = Integer.parseInt(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            int nextStart = Integer.parseInt(plans[i + 1][1]);

            int timeLeft = nextStart - start;

            if (timeLeft >= playTime) {
                result.add(name);
                timeLeft -= playTime;

                while (timeLeft > 0 && !stack.isEmpty()) {
                    Work prev = stack.pop();
                    if (timeLeft >= prev.remain) {
                        result.add(prev.name);
                        timeLeft -= prev.remain;
                    } else {
                        prev.remain -= timeLeft;
                        stack.push(prev);
                        break;
                    }
                }
            } else {
                stack.push(new Work(name, playTime - timeLeft));
            }
        }

        // 마지막 과제
        result.add(plans[plans.length - 1][0]);

        // 멈춘 과제 마저 처리
        while (!stack.isEmpty()) {
            result.add(stack.pop().name);
        }

        return result.toArray(new String[0]);
    }
}
