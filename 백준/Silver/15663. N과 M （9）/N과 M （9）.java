
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] nums;

    static int[] arr;
    static boolean[] visit;
    static Set<String> checkDup = new HashSet<String>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        visit = new boolean[n];
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        back(0);
        System.out.println(sb);
    }

    private static void back(int depth) {
        if (depth == m) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < m; i++) {
                temp.append(arr[i]).append(" ");
            }
            if(!checkDup.contains(temp.toString())){
                sb.append(temp.toString()).append("\n");
                checkDup.add(temp.toString());
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                arr[depth] = nums[i];
                back(depth + 1);
                visit[i] = false;
            }
        }
    }
}
