import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//내려가기
public class Main {
    static int n;
    static int maxTemp0, maxTemp1, maxTemp2;
    static int minTemp0, minTemp1, minTemp2;
    static int[] maxDp = new int[3];
    static int[] minDp = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int num0 = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            maxTemp0 = Math.max(maxDp[0],maxDp[1]) + num0;
            maxTemp1 = Math.max(Math.max(maxDp[0],maxDp[1]),maxDp[2]) + num1;
            maxTemp2 = Math.max(maxDp[1],maxDp[2]) + num2;

            maxDp[0] = maxTemp0;
            maxDp[1] = maxTemp1;
            maxDp[2] = maxTemp2;


            minTemp0 = Math.min(minDp[0],minDp[1]) + num0;
            minTemp1 = Math.min(Math.min(minDp[0],minDp[1]),minDp[2]) + num1;
            minTemp2 = Math.min(minDp[1],minDp[2]) + num2;

            minDp[0] = minTemp0;
            minDp[1] = minTemp1;
            minDp[2] = minTemp2;
        }

        System.out.print(Math.max(maxDp[0],Math.max(maxDp[1],maxDp[2])) + " ");
        System.out.println(Math.min(minDp[0],Math.min(minDp[1],minDp[2])));
    }
}
