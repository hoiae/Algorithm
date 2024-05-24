import java.util.*;
import java.io.*;

public class Main {
    static Set<String> word;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        word = new HashSet<>();
        word.add("pi");
        word.add("ka");
        word.add("chu");
        for(int i = 0; i < str.length();){
            if(i + 1 >= str.length()){
                System.out.println("NO");
                return;
            }
            String now = str.substring(i, i + 2);
            //2글자
            if(word.contains(now)){
                i += 2;
                continue;
            }
            //3글자
               if(i + 2 >= str.length()){
                System.out.println("NO");
                return;
            }
            now = str.substring(i, i + 3);
            if(word.contains(now)){
                i += 3;
                continue;
            }
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}
