import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] numbers = new int[9];
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int i = 0; i < 9; i++){
            int currNumber = Integer.parseInt(br.readLine());
            numbers[i] = currNumber;
            sum += currNumber;
        }
        Arrays.sort(numbers);

        int index1 = 0;
        int index2 = 0;
        breakpoint:
        for(int i = 0; i < 9 - 1; i++){
            for(int j = i + 1; j < 9 ; j++){
                if(sum - numbers[i] - numbers[j] == 100){
                    index1 = i;
                    index2 = j;
                    break breakpoint;
                }
            }
        }

        for (int i = 0; i < 9; i++){
            if( i != index1 && i != index2){
                System.out.println(numbers[i]);
            }
        }
    }
}
