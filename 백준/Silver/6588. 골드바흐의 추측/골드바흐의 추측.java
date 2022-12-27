import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    static final int MAX = 1000000 + 1;
    static boolean[] primeNumbers = new boolean[MAX];
    public static void main(String[] arg) throws IOException {
        makePrimeNumbers();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int number = Integer.parseInt(br.readLine());
            if(number == 0) break;
            getTwoEvenNumber(number);
        }


    }
    private static void makePrimeNumbers() {
        Arrays.fill(primeNumbers,true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;
        for(int i = 2; i * i < MAX; i++){
            if(primeNumbers[i] == true){
                for(int j = i * i; j < MAX; j = j + i){
                    primeNumbers[j] = false;
                }
            }
        }
    }
    private static void getTwoEvenNumber(int number) {
        for(int i = 3; i <= number; i += 2){
//            int evenNumber = number - i;
//            if(primeNumbers[evenNumber]){
            if(primeNumbers[i]&&primeNumbers[number-i]){
                System.out.println(number+" = " + i + " + " + (number-i));
                return;
            }
        }
        System.out.println("Goldbach's conjecture is wrong.");
    }
}
