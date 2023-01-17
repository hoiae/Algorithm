
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr;
    static boolean[] visit;
    static int[] temp;

    static int cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        do{
            if(cnt != 0)
                sb.append("\n");
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            visit = new boolean[k];
            temp = new int[6];
            for(int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            dfs(0,0);
            cnt++;
        }while(k != 0);
        System.out.println(sb);
    }

    private static void dfs(int index, int depth) {
        if(depth == 6){
            for(int i = 0; i < 6; i++){
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = index; i < k; i++){
            if(!visit[i]){
                visit[i] = true;
                temp[depth] = arr[i];
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}
