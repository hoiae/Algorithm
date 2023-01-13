
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        savePermutation();
        permutation();
        System.out.println(sb);
    }

    private static void permutation() {
        while (true) {
            int index = n - 1;
            //[i] > [i-1] 중 가장 큰 값 찾기
            while (index != 0 && arr[index] <= arr[index - 1]) {
                index--;
            }
            if(index == 0){
                return;
            }
            for (int i = n - 1; i >= index; i--) {
                if (arr[i] > arr[index - 1]) {
                    int temp = arr[index - 1];
                    arr[index - 1] = arr[i];
                    arr[i] = temp;
                    break;
                }
            }

            for (int i = 0; i < (n - index) / 2; i++) {
                int temp = arr[index + i];
                arr[index + i] = arr[n - 1 - i];
                arr[n - 1 - i] = temp;
            }

            savePermutation();
        }
    }

    private static void savePermutation() {
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
    }
}
