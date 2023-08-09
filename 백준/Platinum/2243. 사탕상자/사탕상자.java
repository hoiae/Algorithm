
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 1000000;
    static int leafnode;
    static int[] tree = new int[MAX * 2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

//        tree세팅
        leafnode = 1;
        while(leafnode < MAX){
            leafnode *= 2;
        }

        tree = new int[leafnode * 2];


        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){
                //사탕을 꺼내는 경우
                //앞에서 부터 누적합을 사용해야함.
                //getCandy(leafnode 시작인덱스,leafnode 마지막인덱스, 현재 node, )
                //update해줌
                int b = Integer.parseInt(st.nextToken());
                int candy = getCandy(1, leafnode, 1, b);
                update(candy, -1);
                bw.write(candy + "\n");
            }else{
                //사탕을 넣는 경우
                //update: tree[b]에서 c만큼 더해준 후, root 노드까지 갱신함.

                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                update(b,c);
            }
        }

        bw.flush();
        bw.close();

    }

    private static int getCandy(int left, int right, int node, int sum) {
        if(left == right) return left;
        int mid = (left + right) / 2;
        if(tree[node * 2] >= sum){
            return getCandy(left, mid, node * 2, sum);
        }else{
            return getCandy(mid + 1, right, node*2 + 1, sum - tree[node * 2]);
        }

    }

    private static void update(int index, int diff) {
        index = leafnode + index - 1;
        tree[index] += diff;
        
        while( index > 1){
            tree[index / 2] += diff;
            index = index / 2;
        }
    }
}
