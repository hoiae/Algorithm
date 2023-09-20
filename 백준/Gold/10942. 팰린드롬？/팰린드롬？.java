
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] IsPalindrome;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());//숫자 수
        int[] nums = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); //질문개수
        IsPalindrome = new boolean[N + 1][N + 1];

        for(int i = 1;  i <= N; i++){
            for(int j = 1; j <= i ; j++){
                int left = j;
                int right = i;
                boolean isOk = true;
                while(left <= right){
                    if(nums[left++] != nums[right--]){
                        isOk = false;
                        break;
                    }
                }
                if(isOk){
                    IsPalindrome[j][i] = true;
                }
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int result = 0;
            if(IsPalindrome[from][to]){
                result = 1;
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}
