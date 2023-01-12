
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        permutation();
    }

    private static void permutation() {
        int index = n - 1;
        while(index > 0 && arr[index - 1] >= arr[index]) {
            index -= 1;
        }
//        int index = 0;
//        for(int i = n - 1; i > 0; i--){
//            if(arr[i] > arr[i - 1]){
//                index = arr[i] > arr[index] ? i : index;
//            }
//        }
        if (index == 0) {
            System.out.println("-1");
            System.exit(0);
        }

        for (int i = n - 1; i >= index; i--) {
            if (arr[i] > arr[index - 1]) {
                int temp = arr[i];
                arr[i] = arr[index - 1];
                arr[index - 1] = temp;
                break;
            }
        }

        for (int i = 0; i < (n - index) / 2; i++) {
            int temp = arr[index + i];
            arr[index + i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
