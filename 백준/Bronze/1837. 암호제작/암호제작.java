import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int max = 1000000;
    static boolean[] isPrime = new boolean[max + 1];
    static String p;
    static int k;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        p = st.nextToken();
        k = Integer.parseInt(st.nextToken());

        for (int i = 2; i < k; i++) {
            if (isPrime[i]) {
                sum = 0;
                for (int j = 0; j < p.length(); j++) {
                    sum = sum * 10 + p.charAt(j) - '0';
                    sum %= i;
                }
                if (sum == 0) {
                    System.out.println("BAD " + i);
                    return;
                }
            }
        }
        System.out.println("GOOD");
    }
}

