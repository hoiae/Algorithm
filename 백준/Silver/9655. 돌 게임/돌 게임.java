import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String ans = "SK";
		
		if(n%2 == 0) {
			ans = "CY";
		}
		
		System.out.println(ans);
	}

}