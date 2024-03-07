import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int ans = 0;
		while(n > 0) {
			if(n % 5 == 0) {
				ans += n/5;
				n = n % 5;
			}else {
				ans++;
				n -= 2;
			}
		}
		
		if(n != 0) {
			ans = -1;
		}
		System.out.println(ans);
	}

}