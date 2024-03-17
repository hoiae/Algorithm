import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = n;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Set<Character> set = new HashSet<>();

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (!set.contains(c)) {
                    set.add(c);
                    continue;
                }
                if (input.charAt(j - 1) == c) {
                    continue;
                }
                cnt--;
                break;
            }
        }

        System.out.println(cnt);
    }
}