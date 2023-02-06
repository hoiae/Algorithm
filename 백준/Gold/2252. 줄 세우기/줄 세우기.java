import java.io.*;
import java.util.*;

//백준2256번 - 줄세우기
public class Main {
    static int n,m;
    static int[] arr;
    static ArrayList<Integer>[] list;//?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        list = new ArrayList[n + 1];

        for(int i = 1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        int before = 0;
        int after = 0;
        //초기
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            before = Integer.parseInt(st.nextToken());
            after = Integer.parseInt(st.nextToken());

            arr[after] = arr[after] + 1;
            list[before].add(after);
        }

        //최초 탐색할 학생 찾기
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <=n; i++){
            if(arr[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int now = q.poll();
            bw.write(now + " ");
            
            for(int i = 0; i < list[now].size(); i++){
                int index = list[now].get(i);
                if(index > 0){
                    arr[index]--;
                    if(arr[index] == 0){
                        q.add(index);
                    }
                }
            }
        }

        bw.flush();
        bw.close();
    }
}