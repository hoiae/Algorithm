import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String p = br.readLine();

		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			out:for (int start = 0; start < str.length(); start++) {
				int index = 0;
				int strIndex = start;
				while (str.charAt(strIndex) == p.charAt(index)) {
					strIndex++;
					index++;
					if (strIndex == str.length()) {
						strIndex = 0;
					}
					if (index == p.length()) {
						cnt++;
						break out;
					}
				}

			}
		}
		System.out.println(cnt);
	}

}