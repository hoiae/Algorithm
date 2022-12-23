import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i = 1; i <=number; i++){
            sum += i * (number / i);
        }
        System.out.println(sum);
    }
}
