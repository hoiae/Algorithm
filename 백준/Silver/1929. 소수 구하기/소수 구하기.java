import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    public static  void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int startNumber = Integer.parseInt(st.nextToken());
        int endNumber = Integer.parseInt(st.nextToken());

        isPrime(startNumber,endNumber);


    }

    private static void isPrime(int startNumber, int endNumber) {
        boolean[] arr = new boolean[endNumber+1];
        Arrays.fill(arr,true);
        arr[0] = false;
        arr[1] = false;
        for(int i = 2; i * i < arr.length; i++){
            if(arr[i] ==true){
                for(int j = i * i; j < arr.length; j = j + i){
                    arr[j] = false;
                }
            }
        }
        showPrime(arr, startNumber);
    }

    private static void showPrime(boolean[] arr, int startNumber) {
        for(int i = startNumber; i < arr.length; i++){
            if(arr[i] == true)
                System.out.println(i);
        }
    }
}