import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		String[] arr = new String[n];
		HashSet<String> set = new HashSet<String>();
		
		for(int i=0; i<n; ++i) {
			arr[i] = br.readLine();
		}
		for(int i=1; i<=arr[0].length(); ++i) {
			for(int j=0; j<n; ++j) {
				set.add(arr[j].substring(arr[j].length()-i));
			}
			if(set.size() == n) {
				ans = i;
				break;
			}
			set.clear();
		}
        System.out.println(ans);
	}	
}