
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int UP = 0;
    static int DOWN = 1;
    static int LEFT = 2;
    static int RIGHT = 3;
    static int N;
    static int Max = Integer.MIN_VALUE;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(-1, 0, map.clone());
        System.out.println(Max);
    }

    private static void dfs(int direction, int cnt, int[][] map) {
        Max = Math.max(Max, move(direction, map));

        if (cnt == 5) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            dfs(i,cnt + 1, copyMap(map));
        }
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copyArr = new int[N][N];
        for(int j = 0;  j < N; j++){
            copyArr[j] = map[j].clone();
        }
        return copyArr;
    }

    private static void printMap(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int move(int direction, int[][] map) {
        if (direction == UP) {
            moveUp(map);
        } else if (direction == DOWN) {
            moveDown(map);
        } else if (direction == LEFT) {
            moveLeft(map);
        } else if (direction == RIGHT) {
            moveRight(map);
        }
        return getMaxValue(map);
    }

    private static int getMaxValue(int[][] map) {
        int max= Integer.MIN_VALUE;
        for(int i = 0;  i < N; i++){
            for(int  j = 0;  j < N; j++){
               max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }

    private static void moveUp(int[][] map) {
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (map[j][i] == 0) continue; //0인경우
                else {//값을 가지고 있는 경우
                    int row = j;
                    //가장 첫번째 줄이거나, 0이 아닌 값을 만난 경우 종료
                    while (row - 1 >= 0 && map[row - 1][i] == 0) {
                        row--;
                    }
                    //row가 이동할 위치의 값이 0인 경우, 위치 이동
                    //row가 이동할 위치의 값이 0아 아닌경우, 상단의 값을 비교함, 동일한 값이 인경우
                    if (row - 1 >= 0 && map[row - 1][i] == map[j][i] && !visited[row - 1][i]) {
                        map[row - 1][i] = map[row - 1][i] * 2;
                        map[j][i] = 0;
                        visited[row - 1][i] = true;
                    } else {
                        if(row == j) continue;
                        map[row][i] = map[j][i];
                        map[j][i] = 0;
                    }

                }
            }
        }
    }


    private static void moveDown(int[][] map) {
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (map[j][i] == 0) continue; //0인경우
                else {//값을 가지고 있는 경우
                    int row = j;
                    //가장 첫번째 줄이거나, 0이 아닌 값읆 만난 경우 종료
                    while (row + 1 < N && map[row + 1][i] == 0) {
                        row++;
                    }
                    //row가 이동할 위치의 값이 0인 경우, 위치 이동
                    //row가 이동할 위치의 값이 0아 아닌경우, 하단의 값을 비교함, 동일한 값이 인경우

                    if (row + 1 < N && map[row + 1][i] == map[j][i] && !visited[row + 1][i]) {
                        map[row + 1][i] = map[row + 1][i] * 2;
                        map[j][i] = 0;
                        visited[row + 1][i] = true;
                    } else {
                        if(row == j) continue;
                        map[row][i] = map[j][i];
                        map[j][i] = 0;
                    }

                }
            }
        }
    }

    private static void moveLeft(int[][] map) {
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] != 0) {//값을 가지고 있는 경우
                    int col = j;
                    //가장 첫번째 줄이거나, 0이 아닌 값읆 만난 경우 종료
                    while (col - 1 >= 0 && map[i][col - 1] == 0) {
                        col--;
                    }
                    //col이 이동할 위치의 값이 0인 경우, 위치 이동
                    //coldl 이동할 위치의 값이 0아 아닌경우, 하단의 값을 비교함, 동일한 값이 인경우
                    if (col - 1 >= 0 && map[i][col - 1] == map[i][j] && !visited[i][col - 1]) {
                        map[i][col - 1] = map[i][j] * 2;
                        map[i][j] = 0;
                        visited[i][col - 1] = true;
                    } else {
                        if(col == j) continue;
                        map[i][col] = map[i][j];
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    private static void moveRight(int[][] map) {
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (map[i][j] != 0) {//값을 가지고 있는 경우
                    int col = j;
                    //가장 첫번째 줄이거나, 0이 아닌 값읆 만난 경우 종료
                    while (col + 1 < N && map[i][col + 1] == 0) {
                        col++;
                    }
                    //col은 0인 위치에 놓인다.
                    //col + 1 칸의 값이  이동중인 값과 동일한 경우 , 병합
                    //col 다음 칸의 값과 다른 경우,
                    if (col + 1 < N && map[i][col + 1] == map[i][j] && !visited[i][col + 1]) {
                        map[i][col + 1] = map[i][col + 1] * 2;
                        map[i][j] = 0;
                        visited[i][col + 1] = true;
                    } else {
                        if(col == j) continue;
                        map[i][col] = map[i][j];
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

}
