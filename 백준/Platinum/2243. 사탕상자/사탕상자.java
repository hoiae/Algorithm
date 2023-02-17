
import java.io.*;
import java.util.StringTokenizer;

//백준 2243 - 사탕상자
public class Main {
    static int n,a,b,c,firlstLeaf;
    static int[] grade = new int[1000000 + 1];
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        firlstLeaf = 1;
        while(firlstLeaf < 1000000) firlstLeaf = firlstLeaf * 2;
        tree = new int[firlstLeaf*2];

        for(int i = 0;  i < n; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            //순위가 b인 사탕을 하나 꺼내어 출력함.
            if(a == 1){
                b = Integer.parseInt(st.nextToken());
                int candy = getCandy(1, firlstLeaf,1, b); //앞에서 부터 B번째에 있는 사탕 찾음
                bw.write(candy+"\n");
                update(candy,-1);
            }
            //우선순위가 b인 사탕을 양수개 만큼 넣거나 / 음수개 만큼 뺌;
            else {
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                update(b,c);
            }
        }
        bw.flush();
        bw.close();
    }

    private static void update( int index,int diff) {
        int start = firlstLeaf - 1 + index;
        tree[start] += diff;
        start /= 2;
        while(start != 0){
            tree[start] += diff;
            start /= 2;
        }
    }

    //이분탐색 세그먼트 트리
    private static int getCandy(int left, int right, int node, int target) {
        if(left == right) return left;
        int mid  = (left + right)/2;
        if(tree[node*2]>=target){
            return getCandy(left,mid,node*2,target);
        }else{
            return getCandy(mid + 1, right,node*2+1,target-tree[node*2]);
        }
    }
}
