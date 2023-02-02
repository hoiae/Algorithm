
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int cnt;
    static boolean[] isPrime;
    static int[] delete;

    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        isPrime = new boolean[n + 1];//
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                cnt++;//소수를 찾았을 경우 카운트
            }
            if (cnt == k) {
                System.out.println(i);
                return;
            }
            for (int j = i * i; j <= n; j += i) {
                if (isPrime[j]){
                    cnt++; // 소수의 배수를 지우는 경우 카운트
                    isPrime[j] = false;
                }
                if (cnt == k) {
                    System.out.println(j);
                    return;
                }
            }

        }
    }
}
