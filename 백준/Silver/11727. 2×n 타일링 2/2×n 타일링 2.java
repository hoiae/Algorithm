
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n + 1];

        if(n == 1){
            System.out.println(1);
            return;
        }

        result[1] = 1;
        result[2] = 3;

        for(int i = 3;  i < result.length; i++){
            result[i] = (result[i - 1] + 2 * result[i - 2]) % 10007;
        }

        System.out.println(result[n]);
    };
}
