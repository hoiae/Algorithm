
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] polynominos = {
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, {{0, 0}, {1, 0}, {2, 0}, {1, 1}}, {{1, 0}, {0, 1}, {1, 1}, {2, 1}},
            {{1, 0}, {0, 1}, {1, 1}, {1, 2}}, {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, {{1, 0}, {1, 1}, {1, 2}, {0, 2}},
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, {{2, 0}, {0, 1}, {1, 1}, {2, 1}}, {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}}, {{0, 0}, {1, 0}, {0, 1}, {2, 0}}, {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, {{1, 0}, {1, 1}, {0, 1}, {0, 2}}, {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{0, 1}, {1, 1}, {1, 0}, {2, 0}}};
    static int[][] arr;
    static int maxSum;
    static int N;
    static int M;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        //배열 입력받기
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }
        //모든 인덱스를 순회하기
        for(int row = 0; row < N; row ++){
            for(int col =0; col < M; col ++){
                getSumOfNumbers(row,col);
            }
        }
        System.out.println(maxSum);
    }

    private static void getSumOfNumbers(int row, int col) {
        for(int i = 0; i < polynominos.length; i++){
            int sum = 0;
            for(int j = 0; j < 4; j++){
                int Row = row + polynominos[i][j][0];
                int Col = col + polynominos[i][j][1];
                if(Row >= N || Col >= M){
                    break;
                }
                sum += arr[Row][Col];
            }
            maxSum = Math.max(maxSum, sum);
        }
    }

}