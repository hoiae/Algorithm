import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        //trie에 insert
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            set.add(str);
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if(set.contains(str)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
