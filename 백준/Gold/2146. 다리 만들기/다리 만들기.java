import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int minDist;
	static int n;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n][n];
		minDist = Integer.MAX_VALUE;
		solve();
		if(minDist ==  Integer.MAX_VALUE) {
			minDist = 0;
		}
		System.out.println(minDist);
		//1.섬을 그룹화한다.
		//2.시작지점을 가지고 탐색하며 0이아닌 다른 섬에 도달하면 점수를 기록한다.
		
	}
	private static void solve() {
		//1.그룹화
		int groupIdx = 0;
		for(int i = 0; i< n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					group(++groupIdx,i,j);
				}
			}
		}
		
		//2.최단 거리를 찾음
		for(int i = 0; i< n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] != 0) {
					visited = new boolean[n][n];
					findMindist(map[i][j],i,j);
				}
			}
		}
		
		
	}
	private static void findMindist(int sGroupId, int startX, int startY) {
		//최단거리인 minDist를 갱신해야한다.
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->{
			return Integer.compare(o1[3], o2[3]);
		}) ;//[0] = x, [1] = y, [2] = 그룹번호, [3]=이동거리 
		visited[startX][startY] = true;
		q.add(new int[] {startX,startY,sGroupId,0});
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int groupId = now[2];
			int dist = now[3];
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(!isOnRange(nx,ny) || visited[nx][ny]) 
					continue;
				
		
				visited[nx][ny] = true;
				//같은 그룹인 경우
				if(map[nx][ny] == sGroupId) {
					q.add(new int[] {nx, ny, groupId, dist});
				}
				//0인 경우
				else if(map[nx][ny] == 0) {
					q.add(new int[] {nx, ny, groupId, dist + 1});
				}
				//다른 그룹인 경우
				else {
					minDist = Math.min(minDist, dist);
				}
				
			}
		}		

	}
	private static void group(int groupIdx, int startX, int startY) {
		Queue<int[]> q = new LinkedList<>();//[0] = x, [1] = y;
		q.add(new int[]{startX,startY});
		visited[startX][startY] = true;
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			map[x][y] = groupIdx;
			
			for(int i = 0; i< 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(!isOnRange(nx,ny) || map[nx][ny] == 0 || visited[nx][ny]) 
					continue;
				
				visited[nx][ny] = true;
				q.add(new int[] {nx,ny});
			}
		}
		
	}
	private static boolean isOnRange(int nx, int ny) {
		if(nx < 0 || ny < 0 || nx >= n || ny>= n)
		return false;
		
		return true;
	}

}