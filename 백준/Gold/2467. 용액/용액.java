import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        int left = 0;
        int right = n - 1;
        int lValue = nums[left];
        int rValue = nums[right];
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                lValue = nums[left];
                rValue = nums[right];
            }
            if (sum > 0) {
                right--;
            } else if(sum < 0) {
                left++;
            } else{
                break;
            }
        }
        System.out.println(lValue + " " + rValue);
    }
}
