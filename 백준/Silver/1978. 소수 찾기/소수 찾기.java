import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int count = 0;
        for(int i = 0; i < number; i++){
            count += isPrimeNumber(Integer.parseInt(st.nextToken()));
        }
        System.out.println(count);
        }

    private static int isPrimeNumber(int currNumber) {
        if(currNumber == 0 || currNumber == 1)
            return 0;
        for(int i = 2; i < currNumber; i++){
            if(currNumber % i == 0)
                return 0;
        }
        return 1;
    }
}


