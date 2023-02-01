
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//최대힙
public class Main {
    static int n;
    static int command;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            command = Integer.parseInt(br.readLine());
            if (command == 0) {
                Integer curr = pq.poll();
                if (curr == null) {
                    sb.append(0).append("\n");

                } else {
                    sb.append(curr).append("\n");
                }
                continue;
            }
            pq.add(command);
        }
        System.out.println(sb);
    }
}
