import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();

        long lcm = a * b / gcd(a, b);

        System.out.println(lcm);
    }
    
     public static long gcd(long a, long b){
        while(b!=0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
