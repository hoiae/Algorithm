
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static int[] childs;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        childs = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < M; j++){
            childs[j] = Integer.parseInt(st.nextToken());
        }

        boolean ans = solve();
        if(ans){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    private static boolean solve() {
        for (int i = 0; i < M; i++) {
            int box = pq.poll();
            if(box >= childs[i]){
                pq.offer(box - childs[i]);
            }else{
                return false;
            }
        }

        return true;
    }
}
