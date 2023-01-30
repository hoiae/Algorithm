
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] alpha = new int[26];

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String str;
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for(int j = 0; j < str.length(); j++){
             alpha[str.charAt(j) - 'A'] += (Math.pow(10, str.length() - j - 1 ));
            }
        }

        Arrays.sort(alpha);

        int number = 9;
        int result = 0;
        for(int i = 25; i>=0; i--){
            if(alpha[i] == 0)
                continue;
            result += (alpha[i] * number);
            number--;
        }

        System.out.println(result);
    }
}
