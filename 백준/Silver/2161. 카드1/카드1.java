import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<>();
		
		ArrayList<Integer> l = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		while (q.size() > 1) {
			l.add(q.poll());

			if (q.size() == 1) {
				break;
			}
			q.add(q.poll());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < l.size(); i++) {
			sb.append(l.get(i)+" ");
		}
		
		sb.append(q.poll());
		System.out.println(sb);
	}
}