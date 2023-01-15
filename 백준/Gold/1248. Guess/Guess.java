import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visit = new boolean[21]; // -10부터 10까지 담아야함 21개 크기 필요
    static char[][] signs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        arr = new int[n];
        signs = new char[n][n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                signs[i][j] = temp.charAt(index++);
            }
        }

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
            System.exit(0);
        }
        for (int i = -10; i <= 10; i++) {
            arr[depth] = i;
            if (check(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean check(int depth) {
        for (int i = 0; i <= depth; i++) {
            int sum = 0;
            for (int j = i; j <= depth; j++) {
                sum += arr[j];
                if (signs[i][j] == '+' && sum <= 0) {
                    return false;
                } else if (signs[i][j] == '-' && sum >= 0) {
                    return false;
                } else if (signs[i][j] == '0' && sum != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
