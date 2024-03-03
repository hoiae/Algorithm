
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];

        List<Integer> ans = new ArrayList<>();

        int index = 0;
        int cnt = 0;
        while(n != ans.size()){
            index++;
            if(index > n) index = 1;

            if(!visited[index]){
                cnt++;
            }

            if(cnt == k){
                ans.add(index);
                visited[index] = true;
                cnt = 0;
            }

        }
        String str = ans.toString().replace('[','<').replace(']','>');
        System.out.println(str);

    }
}
