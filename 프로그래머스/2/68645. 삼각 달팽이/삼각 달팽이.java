import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n]; 
        int x = -1, y = 0;
        int num = 1;       
        int max = n * (n + 1) / 2;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) x++;          // 아래
                else if (i % 3 == 1) y++;     // 오른쪽
                else if (i % 3 == 2) {// 대각선 위
                    x--; y--; 
                } 

                arr[x][y] = num++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                list.add(arr[i][j]);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
