
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;  i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] asc= new int [n];
        int[] desc = new int[n];
        //i를 증가시킨다.
        asc[0] = 1;
        for (int i = 1; i < n; i++) {
            asc[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]){
                    asc[i] = Math.max(asc[j] + 1,asc[i]);
                }
            }
        }

        desc[n - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            desc[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if(nums[i] > nums[j]){
                    desc[i] = Math.max(desc[j] + 1, desc[i]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n ; i++) {
            ans = Math.max(ans, asc[i] + desc[i]);
        }
        System.out.println(ans - 1);

    }
}
