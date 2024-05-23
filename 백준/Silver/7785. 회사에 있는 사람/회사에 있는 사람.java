import java.io.*;
import java.util.*;
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        TreeSet<String> visit = new TreeSet<>((o1,o2) -> -1 * o1.compareTo(o2));
        
        for(int i = 0; i < n; i++){
            String name = br.readLine().split(" ")[0];
            if(visit.contains(name)){
                visit.remove(name);
            }else{
                visit.add(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String str : visit){
            sb.append(str+"\n");
        }
        System.out.println(sb);
    }
}
