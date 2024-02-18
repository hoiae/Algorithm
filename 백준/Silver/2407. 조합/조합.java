
import java.math.BigInteger;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2407
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = BigInteger.valueOf(sc.nextInt());
        BigInteger m = BigInteger.valueOf(sc.nextInt());

        BigInteger result = factorial(n).divide
                (factorial(m).multiply(factorial(n.subtract(m))));

        System.out.println(result);
    }

    private static BigInteger factorial(BigInteger n) {
        if(n.intValue() <= 1) return BigInteger.valueOf(1);
        return n .multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
