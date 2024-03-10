import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		TreeSet<String> set = new TreeSet<>((o1, o2) -> {
			if (o1.length() != o2.length()) {
				return o1.length() - o2.length();
			}

			return o1.compareTo(o2);

		});
		
		for(int i = 0; i < n; i++) {
			set.add(sc.next());
		}
		
		for(String str : set) {
			System.out.println(str);
		}
	}

}