import java.util.*;

class Solution {
    static List<Long> nums = new ArrayList<>();
    static List<Character> ops = new ArrayList<>();
    static char[] opSet = {'+', '-', '*'};
    static boolean[] visited = new boolean[3];
    static long max = 0;

    public long solution(String expression) {
        StringBuilder sb = new StringBuilder();
        for (char ch : expression.toCharArray()) {
            if (ch == '+'|| ch  == '-' ||ch == '*') {
                nums.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                ops.add(ch);
                
            } else {
                sb.append(ch);
            }
        }
        nums.add(Long.parseLong(sb.toString()));
        permute(new char[3], 0);
        return max;
    }

    private void permute(char[] order, int depth) {
        if (depth == 3) {
            calculate(order);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = opSet[i];
                permute(order, depth + 1);
                visited[i] = false;
            }
        }
    }

    private void calculate(char[] precedence) {
        List<Long> tempNums = new ArrayList<>(nums);
        List<Character> tempOps = new ArrayList<>(ops);

        for (char op : precedence) {
            for (int i = 0; i < tempOps.size(); ) {
                if (tempOps.get(i) == op) {
                    long a = tempNums.remove(i);
                    long b = tempNums.remove(i);
                    long result = apply(a, b, op);
                    tempNums.add(i, result);
                    tempOps.remove(i);
                } else {
                    i++;
                }
            }
        }

        max = Math.max(max, Math.abs(tempNums.get(0)));
    }

    private long apply(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return 0;
    }
}
