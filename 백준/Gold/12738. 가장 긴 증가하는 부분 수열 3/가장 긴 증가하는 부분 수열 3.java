import java.io.*;
import java.util.*;
/*
 * Longest Increasing subsequence의 길이를 구하는 문제
 * 인덱스를 n까지 증가시키며 lis배열을 만든다.
 * 1. 대상이되는 숫자가 lis의 가장 뒤의 값보다 크면 마지막에 추가한다.
 * 2. 작거나 같은 경우, 대상이되는 숫자보다 크면서 그 차이가 가장 작은 값과 교체한다.(low bound)*/
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();		
		int[] lis = new int[n];
		
		lis[0] = nums[0];
		int lastIndex = 0;
		for(int i = 1; i < n; i++) {
			int num = nums[i];
			if(num > lis[lastIndex]) {
				lastIndex++;
				lis[lastIndex] = num;
			}else {
				//lowbound
				int l = 0;
				int r = lastIndex + 1;
				while(l < r) {
					int mid = (l + r)/2;
					if(lis[mid] < num) {
						l = mid + 1;
					}else {
						r = mid;
					}
				}
				lis[l] = num;
			}
		}
//		System.out.println(Arrays.toString(lis));
		System.out.println(lastIndex + 1);
	}
	
}