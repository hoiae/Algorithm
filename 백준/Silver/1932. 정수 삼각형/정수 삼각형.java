
import java.io.*;
import java.util.StringTokenizer;

//정수삼각형 실버1
public class Main {
    static int n;
    static int[][] map;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];

        for(int i = 1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=i; j++){
                int t =  Integer.parseInt(st.nextToken());
                map[i][j] = t;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                map[i][j] += Math.max(map[i - 1][j - 1],map[i - 1][j]);
            }
        }

        for(int i = 1; i <= n; i++){
            max = Math.max(max,map[n][i]);
        }

        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}
