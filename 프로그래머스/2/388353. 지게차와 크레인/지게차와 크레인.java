import java.util.*;

class Solution {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length, m = storage[0].length();
        int H = n + 2, W = m + 2;

        char[][] arr = new char[H][W];
        for (char[] row : arr) Arrays.fill(row, '-');
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i + 1][j + 1] = storage[i].charAt(j);

        for (String req : requests) {
            char target = req.charAt(0);
            if (req.length() == 2) {
                for (int i = 0; i < H; i++)
                    for (int j = 0; j < W; j++)
                        if (arr[i][j] == target)
                            arr[i][j] = '-';
            } else {
                boolean[][] visited = new boolean[H][W];
                Queue<int[]> q = new ArrayDeque<>();
                visited[0][0] = true;
                q.offer(new int[]{0, 0});

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0] + dr[d], nc = cur[1] + dc[d];
                        if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                        if (!visited[nr][nc] && arr[nr][nc] == '-') {
                            visited[nr][nc] = true;
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }

                List<int[]> toRemove = new ArrayList<>();
                for (int i = 1; i < H - 1; i++)
                    for (int j = 1; j < W - 1; j++)
                        if (arr[i][j] == target) {
                            for (int d = 0; d < 4; d++) {
                                int nr = i + dr[d], nc = j + dc[d];
                                if (visited[nr][nc]) {
                                    toRemove.add(new int[]{i, j});
                                    break;
                                }
                            }
                        }
                for (int[] p : toRemove) arr[p[0]][p[1]] = '-';
            }
        }

        int answer = 0;
        for (int i = 1; i < H - 1; i++)
            for (int j = 1; j < W - 1; j++)
                if (arr[i][j] != '-') answer++;

        return answer;
    }
}
