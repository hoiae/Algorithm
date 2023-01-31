
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,min,max,mid,height;
    static int[] nums;

    static long sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            if(max < nums[i]){
                max = nums[i];
            }
        }

        while(min < max){
            mid = (min + max) / 2;
            sum = 0;
            for(int i = 0; i < nums.length; i++){
                height = (nums[i] - mid);
                if(height > 0){
                    sum += height;
                }
            }

            if(sum < m){
                max = mid ;
            }else{
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }
}
