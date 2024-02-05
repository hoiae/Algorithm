import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int result = 0;
		boolean isSubtraction = false; 
		String str =  "";
		for(int i = 0;  i < input.length(); i++) {
			String now = String.valueOf(input.charAt(i));
			if(now.equals("+") || now.equals("-")) {
				
				if(isSubtraction == true) {
					result -= Integer.parseInt(str);
				}else {
					result += Integer.parseInt(str);
				}
				
				if(now.equals("-")) {
					isSubtraction = true;
				}
				str ="";
			}
			else {
				str	+= now;
			} 
		}
		
		if(isSubtraction == true) {
			result -= Integer.parseInt(str);
		}else {
			result += Integer.parseInt(str);
		}
		System.out.println(result);
	}

}