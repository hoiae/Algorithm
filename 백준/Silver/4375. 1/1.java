import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = null;
        while((temp= br.readLine()) != null){
            long num = Integer.parseInt(temp);
            long minMultitple = getMinMultiple(num);
            System.out.println(minMultitple);
        }
    }
    private static long getMinMultiple(long num){
        long currNumber = 0;
        long cnt = 1;
        while(true) {
            currNumber = (currNumber * 10 + 1)%num;
            if(currNumber ==0)
                return cnt;
            cnt ++;
            }
        }

}

