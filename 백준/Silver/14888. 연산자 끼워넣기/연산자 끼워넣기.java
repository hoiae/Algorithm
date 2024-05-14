import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int[] nums;
	static int[] op;
	static int[] arr;//선택된 연산
	static int max;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		arr = new int[n - 1];
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		solve(0);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void solve(int depth) {
		if(depth == n - 1) {
			//연산하기
			int result = nums[0];
			for(int i = 0; i < depth; i++) {
				int opperator = arr[i];
				if(opperator == 0) {//+
					result += nums[i + 1];
				}else if(opperator == 1) {//-
					result -= nums[i + 1];
				}else if(opperator == 2) {//*
					result *= nums[i + 1];
				}else {// /
					result /= nums[i + 1];
				}
			}
			
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				arr[depth] = i;
				solve(depth + 1);
				op[i]++;
			}
		}
		
	}

}