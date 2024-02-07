import java.util.*;
import java.io.*;

public class Main {
	static int N, M, R;
	static int[][] map;
	static int[] commands;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		printMap();

	}

	private static void solve() {
		for (int i = 0; i < R; i++) {
			int command = commands[i];
			if (command == 1) {
				func1();
			} else if (command == 2) {
				func2();
			} else if (command == 3) {
				func3();
			} else if (command == 4) {
				func4();
			} else if(command ==5){ // 5,6
				func5();// 쪼개기
				// 함수
			}else {
				func6();
			}
		}
	}

	private static void func6() {
		int[][] tMap = new int[N][M];
		int nMid = N / 2;
		int mMid = M / 2;

		/* 5번 */
		// 1 -> 4

		int x = 0;
		int y = 0;
		for (int i = 0; i < nMid; i++) {
			for (int j = 0; j < mMid; j++) {
				tMap[x + i + nMid][ y + j] = map[x + i][y + j];
			}
		}
		// 2 -> 1
		x = 0;
		y = mMid;
		for (int i = 0; i < nMid; i++) {
			for (int j = 0; j < mMid; j++) {
				tMap[x + i][y + j -mMid] = map[x + i][y + j];
			}
		}

		// 3 -> 2
		x = nMid;
		y = mMid;
		for (int i = 0; i < nMid; i++) {
			for (int j = 0; j < mMid; j++) {
				tMap[x + i - nMid][y + j] = map[x + i][y + j];
			}
		}
		
		// 4 -> 3 
		x = nMid;
		y = 0;
		for (int i = 0; i < nMid; i++) {
			for (int j = 0; j < mMid; j++) {
				tMap[x + i][y + j + mMid] = map[x + i][y + j];
			}
		}
		
		map = tMap;
//		printMap();
	}

	private static void func5() {
		int[][] tMap = new int[N][M];
		// 쪼개기?
		int nMid = N / 2;
		int mMid = M / 2;

		/* 5번 */
		// 1 -> 2

		int x = 0;
		int y = 0;
		for (int i = 0; i < nMid; i++) {
			for (int j = 0; j < mMid; j++) {
				tMap[x + i][ y + j + mMid] = map[x + i][y + j];
			}
		}
		// 2 -> 3
		x = 0;
		y = mMid;
		for (int i = 0; i < nMid; i++) {
			for (int j = 0; j < mMid; j++) {
				tMap[x + i + nMid][y + j] = map[x + i][y + j];
			}
		}

		// 3 -> 4
		x = nMid;
		y = mMid;
		for (int i = 0; i < nMid; i++) {
			for (int j = 0; j < mMid; j++) {
				tMap[x + i][y + j -mMid] = map[x + i][y + j];
			}
		}
		
		// 4 -> 1 
		x = nMid;
		y = 0;
		for (int i = 0; i < nMid; i++) {
			for (int j = 0; j < mMid; j++) {
				tMap[x + i - nMid][y + j] = map[x + i][y + j];
			}
		}
		
		map = tMap;
	}

	private static void func4() {
		int[][] tMap = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tMap[i][j] = map[j][M - 1 - i];
			}
		}

		map = tMap;
		// N과 M을 교체함
		int temp = M;
		M = N;
		N = temp;
	}

	private static void func3() {
		int[][] tMap = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tMap[i][j] = map[N - 1 - j][i];
			}
		}

		map = tMap;

		// N과 M을 교체함
		int temp = M;
		M = N;
		N = temp;

	}

	private static void func2() {
		int[][] tMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tMap[i][j] = map[i][M - 1 - j];
			}
		}

		map = tMap;
	}

	private static void func1() {
		int[][] tMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tMap[i][j] = map[N - 1 - i][j];
			}
		}
		map = tMap;
	}


	private static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");

			}
			System.out.println();
		}
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		commands = new int[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			commands[i] = Integer.parseInt(st.nextToken());
		}
	}

}