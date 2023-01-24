
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int number;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(br.readLine());

        if (number < 4) {
            result = new int[4];
        } else {
            result = new int[number + 1];
        }
        result[2] = 1;
        result[3] = 1;

        for (int i = 4; i <= number; i++) {
            int cnt = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                cnt = result[i / 2] + 1;
            }
            if (i % 3 == 0) {
                cnt = Math.min(cnt, result[i / 3] + 1);
            }
            cnt = Math.min(cnt, result[i - 1] + 1);
            result[i] = cnt;
        }

        System.out.println(result[number]);
    }
}

