
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int x;
    static int y;

    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;

            max = getLcm(M,N);

            for (int j = x; j < (N * M); j += M) {
                if(j + 1 > max){
                    System.out.println(-1);
                    break;
                }
                if (j % N == y) {
                    System.out.println(j + 1);
                    break;
                }
            }

        }

    }
    private static int getLcm (int a, int b){
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return (M * N) / a;
    }
}
