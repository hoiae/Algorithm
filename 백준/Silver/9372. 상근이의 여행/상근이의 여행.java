import java.util.*;
import java.io.*;
public class Main {
    static List<Integer>[] list;
    static int n,m;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int test = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        for(int t = 0; t < test; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());  
            m = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;

            list = new ArrayList[n + 1];
            for(int i = 1; i <= n; i++){
                list[i] = new ArrayList<>();
            }
            
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            
            for(int i = 1; i <= n; i++){
                min = Math.min(bfs(i),min);
            }
            sb.append(min).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
     
    }
       private static int bfs(int start){
            visited = new boolean[n + 1];
            Queue<Integer> q = new LinkedList<>();
            visited[start] = true;
            q.add(start);
            int cnt = 0;
            while(!q.isEmpty()){
                int now = q.poll();
                for(int next: list[now]){
                    if(visited[next]) continue;
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
            return cnt;
        }
}
