import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String str = sc.next();
		
		
		List<Integer> ps = new ArrayList<>();
		
		int i = 1;
		while(i < str.length() - 1) {
			char l = str.charAt(i-1);
			char c = str.charAt(i);
			char r = str.charAt(i + 1);
			
			if(c == 'O' && l == 'I' && r =='I') {
				int len = 1;
				while(i + 1 + 2 < str.length()) {
					if(str.charAt(i + 2) == 'O' && str.charAt(i + 3) == 'I') {
						len++;
						i += 2;
					}else {
						break;
					}
					
				}
				ps.add(len);
			}
			i++;
		}
		
		int ans = 0;
		for(int temp  : ps) {
			if(temp >=n ) {
				ans += temp - (n-1);				
			}
		}
		System.out.println(ans);
		
	}
}