
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] arr;
    static int maxCount = 0;

    public static void main(String[] srg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //배열 입력 받음
        int N = Integer.parseInt(br.readLine());
        arr = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = row[j];
            }
        }
        //현재 인덱스에서 오른쪽 값이랑 변경 했을 때, 연속되는 최대값 찾기
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N - 1; col++) {
                swapHorizontally(row, col);
                int rowCnt = countHorizontally(row);
                int colCnt = countVertically(col);
                maxCount = Math.max(maxCount, Math.max(rowCnt, colCnt));
//                System.out.println("row: " + row + " col: " + col + " cnt :" + cnt + " maxCount: " + maxCount);
                swapHorizontally(row, col);
            }
        }
        //현재 인덱스에서 위 값이랑 변경 했을 때, 연속되는 최대값 찾기
        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N - 1; row++) {
                swapVertically(row, col);
                int rowCnt = countHorizontally(row);
                int colCnt = countVertically(col);
                maxCount = Math.max(maxCount, Math.max(rowCnt, colCnt));
                swapVertically(row, col);
            }
        }
        System.out.println(maxCount);
    }

    private static int countVertically(int Col) {
        int cnt = 1;
        int currCnt = 1;
        for (int col = 0; col < arr.length; col++) {
            for (int row = 1; row < arr.length; row++) {
                if (arr[row][col].equals(arr[row - 1][col])) {
                    currCnt++;
                    if (currCnt >= cnt) {
                        cnt = currCnt;
                    }
                    continue;
                }
                currCnt = 1;
            }
            currCnt = 1;
        }
        return cnt;
    }

    private static void swapVertically(int row, int col) {
        String temp = arr[row][col];
        arr[row][col] = arr[row + 1][col];
        arr[row + 1][col] = temp;
    }

    private static int countHorizontally(int Row) {
        int cnt = 1;
        int currCnt = 1;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 1; col < arr.length; col++) {
                if (arr[row][col].equals(arr[row][col - 1])) {
                    currCnt++;
                    if (currCnt >= cnt) {
                        cnt = currCnt;
                    }
                    continue;
                }
                currCnt = 1;
            }
            currCnt = 1;
        }
        return cnt;
    }

    private static void swapHorizontally(int row, int col) {
        String temp = arr[row][col];
        arr[row][col] = arr[row][col + 1];
        arr[row][col + 1] = temp;
    }
}
