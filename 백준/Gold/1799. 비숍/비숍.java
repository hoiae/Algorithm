
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int evenCost;
    static int[][] map;
    static int[] max = new int[2];
    public static void main(String[] args) throws IOException {
        //입력받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N % 2 == 0){
            evenCost += 1;
        }
        map = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(1,1,0,0,0,0);
        dfs(1,2,0,0,0, 1);

        System.out.println(max[0] + max[1]);

    }

    private static void dfs(int x, int y, int cnt, long bit1, long bit2, int idx) {
        if(y > N){
           x += 1;
           int diff = y - N + evenCost;
           if(diff % 2 == 1){
               y = 1;
           }else{
               y = 2;
           }
        }
        if(x > N){
            max[idx] = Math.max(max[idx],cnt);
            return;
        }

        //현재 위치에 놓을 수 있는 경우
        if(map[x][y] == 1 && checkBit1(x,y, bit1) && checkBit2(x, y, bit2)){
            long nBit1 = bit1 | (1L << (N + x - y - 1));
            long nBit2 = bit2 | (1L << (x + y - 1));
            dfs(x, y + 2, cnt + 1, nBit1, nBit2, idx);
        }

        dfs(x, y + 2, cnt , bit1, bit2, idx);
    }

    private static boolean checkBit2(int x, int y, long bit2) {
        int result = x + y;
        int bit = 1 << (result - 1);
        //이미 다른 비숍이 위치하는 경우, 놓을 수없음
        if((bit & bit2) == bit){
            return false;
        }
        return true;
    }

    private static boolean checkBit1(int x, int y, long bit1) {
        int result = N + x - y;
        int bit = 1 << (result - 1);
        //이미 다른 비숍이 위치하는 경우, 놓을 수없음
        if((bit & bit1) == bit){
            return false;
        }
        return true;
    }
}
