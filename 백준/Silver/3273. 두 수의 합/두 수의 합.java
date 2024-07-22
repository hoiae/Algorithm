import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int left = 0; 
        int right = n - 1;
        int sum = 0;
        int cnt = 0;
        while(true){
            if(left >= right){
                break;
            }
            sum = nums[left] + nums[right];
            // System.out.println("left =" + left +", right="+ right+", sum=" + sum);

            if(sum < x){
                left++;
            }else if(sum == x){
                cnt++;
                left++;
                // System.out.println(cnt);
            }else{
                right--;
            }
        }
        System.out.println(cnt);        
    }
}
