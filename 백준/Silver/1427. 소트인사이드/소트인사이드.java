import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] n = sc.next().toCharArray();
		
		Arrays.sort(n);
		StringBuilder sb = new StringBuilder();
		for(int i = n.length - 1; i >= 0; i--) {
			sb.append(n[i]);
		}
		System.out.println(sb);
		
	}

}