
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int start, end, sum, cnt;
    static boolean[] isPrime;
    static int[] primeNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //소수 배열 만들기
        makePrimeNumbers();
        sum = primeNumbers[0];
        while (true) {
            if (sum >= n) {
                if (sum == n)
                    cnt++;
                sum -= primeNumbers[start];
                start++;
            } else {
                end++;
                if (end == primeNumbers.length)
                    break;
                sum += primeNumbers[end];
            }
        }
        System.out.println(cnt);
    }

    private static void makePrimeNumbers() {
        isPrime = new boolean[n + 1];
        primeNumbers = new int[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int index = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primeNumbers[index++] = i;
            }
        }
    }
}
