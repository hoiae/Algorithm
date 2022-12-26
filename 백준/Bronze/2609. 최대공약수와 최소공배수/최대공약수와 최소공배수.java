
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = getGcd(a,b);
        int lcm = a*b/gcd;
        System.out.println(gcd);
        System.out.println(lcm);

    }

    private static int getGcd(int a, int b) {
        int A = a;
        int B = b;
        int temp = 0;
        while(B!=0){
            temp= A % B;
            A = B;
            B = temp;
        }
        return A;
    }
}