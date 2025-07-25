import java.util.*;

class Solution {
    static String[][] relation;
    static List<int[]> cands;
    static int r, c;
    static int cnt;

    public int solution(String[][] relation) {
        this.relation = relation;
        r = relation.length;
        c = relation[0].length;
        cnt = 0;

        cands = new ArrayList<>();
        combi(0, new ArrayList<>());

        // 최소성 검사용
        List<Set<Integer>> keys = new ArrayList<>();
        
        cands.sort((a,b) -> a.length - b.length);

        for (int[] arr : cands) {
            Set<Integer> curr = new HashSet<>();
            for (int i : arr) curr.add(i);

            //후보키 중 하나라도 curr의 부분집합이면 skip
            boolean skip = false;
            for (Set<Integer> key : keys) {
                if (curr.containsAll(key)) {
                    skip = true;
                    break;
                }
            }
            if (skip) continue;

            //유일성
            Set<String> set = new HashSet<>();
            for (String[] tuple : relation) {
                StringBuilder sb = new StringBuilder();
                for (int col : arr) {
                    sb.append(tuple[col]).append("|"); // 안전한 구분자
                }
                set.add(sb.toString());
            }

            if (set.size() == r) {
                keys.add(curr);  // 최소성 통과한 후보키 등록
                cnt++;
            }
        }

        return cnt;
    }

    private void combi(int current, List<Integer> choices) {
        if (choices.size() >= 1) {
            cands.add(choices.stream().mapToInt(i -> i).toArray());
        }

        for (int i = current; i < c; i++) {
            choices.add(i);
            combi(i + 1, choices);
            choices.remove(choices.size() - 1);
        }
    }
}
