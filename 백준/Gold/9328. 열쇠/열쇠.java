
import java.io.*;
import java.util.*;

public class Main {
    static boolean[] Keys;
    static int h, w;
    static List<Point>[] DoorPoints = new ArrayList[26];
    static char[][] Map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int cnt;
//    static Set<String> Docs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) { //테스크 케이스 만큼 반복
            bw.write(solve(br) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int solve(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        Map = new char[h][w];
        visited = new boolean[h][w];
        //map을 저장함.
        for (int i = 0; i < h; i++) {
            Map[i] = br.readLine().toCharArray();
        }

        //가지고 있는 키를 저장함. (소문자 -> 대문자로)
        cnt = 0;
        Keys = new boolean[26];
        DoorPoints = new ArrayList[26];
        for (int i = 0; i < DoorPoints.length; i++) {
            DoorPoints[i] = new ArrayList<>();
        }
//        Docs = new HashSet<>(); //문서 저장.
        String keyStr = br.readLine();
        if (!keyStr.equals("0")) {//키를 가지고 있는 경우
            for (int i = 0; i < keyStr.length(); i++) {
                Keys[keyStr.charAt(i) - 'a'] = true;
            }
        }

        //시작 지점을 찾아서 bfs를 진행함.
        //벽이 아닌 모든 지점을 시작함.
        findStartingPoint();
        return cnt;
    }

    private static void findStartingPoint() {
        for (int i = 0; i < h; i++) { //빌딩의 가장 위, 아래 가로방향
            for (int j = 0; j < w; j++) {
                if (i > 0 && i < h - 1 && j > 0 && j < w - 1) {
                    continue;
                }
                if(visited[i][j]){
                    continue;
                }

                if (Map[i][j] != '*') {
                    bfs(i, j);
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
//        System.out.println("startPoint x: "+x+" y: "+y);

        visited[x][y] = true;
        //시작 위치가 문인 경우
        if(Map[x][y] >= 'A' &&  Map[x][y] <= 'Z'){
            if(!Keys[Map[x][y] - 'A']){ //키를 가지고 있지 않은 경우
                DoorPoints[Map[x][y] - 'A'].add(new Point(x, y));
                return;
            }
        }

        //시작 위치가 키인 경우
        if (Map[x][y] >= 'a' && Map[x][y] <= 'z') {
            Keys[Map[x][y] - 'a'] = true;
        }

        //시작 위치가 문서인 경우
        if (Map[x][y] == '$') {
            cnt++;
        }



        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny] && Map[nx][ny] != '*') {
                    visited[nx][ny] = true;
                    //문인 경우
                    if (Map[nx][ny] >= 'A' && Map[nx][ny] <= 'Z') {
                        if (!Keys[Map[nx][ny] - 'A']) { //키가 없는 경우
                            DoorPoints[Map[nx][ny] - 'A'].add(new Point(nx, ny)); //현재 열수 없는 문의 좌표를 저장함.
                            continue;
                        }
                    }
                    //키인 경우
                    else if (Map[nx][ny] >= 'a' && Map[nx][ny] <= 'z') {
                        if (!Keys[Map[nx][ny] - 'a']) { //키를 가지고 있지 않은 경우
                            Keys[Map[nx][ny] - 'a'] = true;
                            //큐에 획득한 키로 방문할 수 있는 곳을 추가함.
                            for(Point point : DoorPoints[Map[nx][ny] - 'a']){
                                q.add(point);
                            }
                        }
                    }
                    //문서인 경우
                    else if (Map[nx][ny] == '$') {
                      cnt++;
                    }

                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
