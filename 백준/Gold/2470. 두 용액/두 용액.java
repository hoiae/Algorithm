import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		
		int left = 0;
		int right = n - 1;
		//0과의 차이를 계산해야함.
		long temp = Math.abs(arr[left] + arr[right]);
		int l=left ,r=right;
		while(left < right) {
			
			long result = arr[left] + arr[right];
			if(Math.abs(result) < temp) {
				temp = Math.abs(result);
				l = left;
				r = right;
			}
			
			if(result < 0) {
				left++;
			}else {
				right--;
			}
		}
		System.out.println(arr[l] +" "+arr[r]);

	}

}