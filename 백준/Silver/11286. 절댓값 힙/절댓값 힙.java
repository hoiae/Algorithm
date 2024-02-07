import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (Math.abs(o1) != Math.abs(o2)) {
				return Integer.compare(Math.abs(o1), Math.abs(o2));
			} else {
				return Integer.compare(o1, o2);
			}
		});
		
		StringBuilder sb= new StringBuilder();
		for(int i = 0;  i < N; i++) {
			int command = sc.nextInt();
			if(command == 0) {
				if(pq.isEmpty()) {
					sb.append(0);
				}else {
					sb.append(pq.poll());
				}
				sb.append("\n");

			}else {
				pq.offer(command);
			}
		}
		System.out.println(sb);
	}

}