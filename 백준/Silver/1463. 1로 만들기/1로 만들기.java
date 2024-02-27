import java.io.*;
import java.util.*;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		dfs(n, 0);
		System.out.println(min);

	}

	private static void dfs(int num, int cnt) {
		if (num == 1) {
			min = Math.min(min, cnt);
			return;
		}

		if (cnt >= min)
			return;
		
		if (num % 3 == 0)
			dfs(num / 3, cnt + 1);
		if (num % 2 == 0)
			dfs(num / 2, cnt + 1);

		dfs(num - 1, cnt + 1);
	}

}