
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int cnt;
    static boolean[] col;
    static boolean[] rightDown;
    static boolean[] rightUp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //체스판 만들기
        col = new boolean[n];
        rightDown = new boolean[n * 2 + 1];
        rightUp = new boolean[n * 2 + 1];

        solve(0);

        System.out.println(cnt);
    }

    private static void solve(int i) {
        if(i == n){
            cnt++;
            return;
        }
        for(int j = 0; j < n; j++){
            if(col[j] == false && rightDown[i - j + n] == false && rightUp[i + j] == false){
                col[j] = true;
                rightDown[i - j + n] = true;
                rightUp[i + j] = true;
                solve(i + 1);
                col[j] = false;
                rightDown[i - j + n] = false;
                rightUp[i + j] = false;
            }
        }
    }
}
