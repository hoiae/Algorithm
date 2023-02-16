
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//소수의 곱
/* 크기 순서대로 생성하는 것은 불가능!
 * 우선 생성하고  우선순위큐를 활용하여 계속해서 정렬하는 것이 정론
 * 이전에 뽑은 값과 현재의 값을 비교하는 로직이 들어가있으면됌*/
public class Main {
    static int k, n;
    static long result;
    static long[] nums;
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        nums = new long[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            nums[i] = Long.parseLong(st.nextToken());
            pq.offer(nums[i]);
        }

        while (n-- > 0) {
            result = pq.poll();
            for (int i = 0; i < k; i++) {
                if (result * nums[i] < Math.pow(2, 31)) {
                    pq.offer(result * nums[i]);
                }
                if (result % nums[i] == 0) {
                    break;
                }
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();

    }
}
