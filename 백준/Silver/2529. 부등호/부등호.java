
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k;
    static char[] sign;
    static boolean[] visit = new boolean[10];

    static List arr = new ArrayList();
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());
        sign = new char[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        dfs( 0,"");
        Collections.sort(arr);

        System.out.println(arr.get(arr.size() - 1));
        System.out.println(arr.get(0));
    }

    private static void dfs(int depth, String numbers) {
        if (depth == k + 1) {
            arr.add(numbers);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (!visit[i]) {
                if (depth == 0 || check(i, depth, numbers)) {
                    visit[i] = true;
                    dfs(depth + 1, numbers + Integer.toString(i));
                    visit[i] = false;
                }
            }
        }
    }

    private static boolean check(int num, int depth, String numbers) {
        char currentSign = sign[depth - 1];

        if( currentSign == '>')
            return numbers.charAt(numbers.length() - 1) - '0' > num;
        return numbers.charAt(numbers.length() - 1) - '0' < num;

    }
}
