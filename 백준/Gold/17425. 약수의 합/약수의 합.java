import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MaxNaturalNumber = 1000000 + 1;
    static long[] sumOfDivisors = new long[MaxNaturalNumber];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int repeat = Integer.parseInt(br.readLine());
        makeSumOfDivisors();
        while (repeat-- > 0){
            sb.append(sumOfDivisors[Integer.parseInt(br.readLine())] + "\n");
        }
        System.out.println(sb);
    }


    private static void makeSumOfDivisors() {
        Arrays.fill(sumOfDivisors,1);
        for(int i = 2; i < sumOfDivisors.length; i++){
            for(int j = 1; j * i < sumOfDivisors.length; j++){
                sumOfDivisors[j * i] += i;
            }
            sumOfDivisors[i] += sumOfDivisors[i-1];
        }
        }
    }