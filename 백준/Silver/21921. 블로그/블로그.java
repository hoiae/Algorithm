import java.io.*;
import java.util.*;

public class Main {
    static int x,n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = x-1;
        int cnt = 1;
        int maxVisit = 0;
        int sum = 0;
        for(int i = 0; i < x; i++){
            sum += arr[i];
            maxVisit += arr[i];
        }
        
        while(right < n - 1){
            sum -= arr[left++];
            sum += arr[++right];
            if(sum == maxVisit){
                cnt++;
            }else if(sum > maxVisit){
                maxVisit = sum;
                cnt = 1;
            }
        }
        
        if(maxVisit == 0){
            System.out.println("SAD");
        }else{
            System.out.println(maxVisit);
            System.out.println(cnt);
        }
    }
}
