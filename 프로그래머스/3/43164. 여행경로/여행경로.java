import java.util.Arrays;
import java.util.Comparator;

class Solution {
    private boolean[] visited;
    private String[] answer;
    private boolean found = false;

    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        visited = new boolean[n];

        // 사전순 정렬
        Arrays.sort(tickets, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
                return a[1].compareTo(b[1]);
            }
        });

        String[] route = new String[n + 1];
        route[0] = "ICN";

        dfs(0, "ICN", route, tickets);
        return answer;
    }

    private void dfs(int depth, String current, String[] route, String[][] tickets) {
        if (found) return; // 정답을 찾으면 더 이상 탐색 X

        if (depth == tickets.length) {
            answer = route.clone(); // 처음으로 완성된 경로가 정답
            found = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                route[depth + 1] = tickets[i][1];
                dfs(depth + 1, tickets[i][1], route, tickets);
                visited[i] = false;
            }
        }
    }
}
