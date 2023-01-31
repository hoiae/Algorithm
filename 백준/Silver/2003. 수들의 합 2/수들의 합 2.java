
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int cnt;
    static int s;
    static int e;
    static int sum;
    static int[] nums;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;  i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        solve();
        System.out.println(cnt);
    }

    private static void solve() {
        while(true){
            if(sum >= m){
              sum -= nums[s];
              s++;
            }else if(e >= n){
                break;
            }else{
                sum += nums[e];
                e++;
            }
            if(sum == m)
                cnt++;
        }
    }
}
