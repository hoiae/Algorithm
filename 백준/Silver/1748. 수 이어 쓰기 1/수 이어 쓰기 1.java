
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (number > 0) {
            int currNumber = number;
            while (currNumber != 0) {
                currNumber = currNumber / 10;
                cnt++;
            }
            number --;
        }
        System.out.println(cnt);
    }
}
