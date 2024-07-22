import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] salary = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            salary[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = m - 1;
        long sum = 0;
        for(int i = 0;  i <= right; i++){
            sum += salary[i];
        }
        long maxSum = sum;
        while(true){
            right++;
            if(right == n) break;
            sum -= salary[left++];
            sum += salary[right];
            maxSum = Math.max(maxSum,sum);
        }
        System.out.println(maxSum);
    }
}
