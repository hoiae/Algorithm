import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);
        
        long cost = 0;
        for(int i = 0; i < n - 1; i++){
            cost += arr[i] * (sum - arr[i]);
            sum-= arr[i];
        }
        System.out.println(cost);
    }
}
