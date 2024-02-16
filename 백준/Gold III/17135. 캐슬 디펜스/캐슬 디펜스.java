import java.io.*;
import java.util.*;

public class Main {

	static int N, M, D;
	static int[][] map;
	static int max;
	static int[] positions;
	static boolean[] visited;

	static class Info implements Comparable<Info> {
		int x;
		int y;
		int dist;

		public Info(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Info o) {
			// 거리가 다른 경우
			if (this.dist != o.dist) {
				return Integer.compare(this.dist, o.dist);
			}
			// 거리가 같은 경우
			return Integer.compare(this.y, o.y);
			
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[M];
		positions = new int[3];
		solve();
		System.out.println(max);

	}

	private static void solve() {
		setArcherPosition(0, 0);
	}

	private static void setArcherPosition(int start, int depth) {
		if (depth == 3) {
			play(); // 지정한 아처의 위치로 게임 시작
			return;
		}

		for (int i = start; i < M; i++) {
			if (!visited[i]) {
				visited[i] = true;
				positions[depth] = i;
				setArcherPosition(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	private static void play() {
		int[][] tempMap = new int[N][M];// 확인을 위해 사용할 맵
		boolean[][] isHit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			tempMap[i] = map[i].clone();
		}
		
		int currentRow = N;
		int hitCount = 0;
		
		while (currentRow > 0) {
			/* 화살 쏨 */
			List<Info> removalPositions = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				// 현재 궁수의 위치
				int archerX = currentRow;
				int archerY = positions[i];
				PriorityQueue<Info> pq = new PriorityQueue<Info>();
				// 궁수의 위로 다찾음. -> 대상중 가장 가까운 친구 선택.
				for (int row = 0; row < archerX; row++) {
					for (int col = 0; col < M; col++) {
						int dist = calculateDist(row, col, archerX, archerY);
						if (dist <= D && tempMap[row][col] == 1) {
							pq.add(new Info(row, col, dist));
						}
					}
				}
				// 가장 짧은 거리에 있는궁수 확인
				if(!pq.isEmpty()) {
					Info target = pq.poll();
					if (!isHit[target.x][target.y]) {
						isHit[target.x][target.y] = true;
						hitCount++;
						removalPositions.add(target);
					}					
				}
			}
			/* 화살에 맞은 타겟 지우기*/
			for(Info target: removalPositions) {
				tempMap[target.x][target.y] = 0;
			}
			/* 이동 함 */
			currentRow--;
		}
		max = Math.max(max, hitCount);

	}

	private static void printMap(int[][] map) {
		for(int i = 0; i < N; i++) {
			for(int j = 0;  j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int calculateDist(int row, int col, int archerX, int archerY) {
		return Math.abs(row - archerX) + Math.abs(col - archerY);
	}



}