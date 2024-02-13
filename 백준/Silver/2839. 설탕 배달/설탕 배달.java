
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        while(true){
            if(n % 5 == 0){
                cnt += n/5;
                break;
            }else if(n < 3){
                cnt = -1;
                break;
            }
            n -=3;
            cnt++;
        }
        System.out.println(cnt);
    }
}
