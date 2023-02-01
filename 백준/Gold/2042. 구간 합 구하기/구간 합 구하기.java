
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구간합 구하기
public class Main {
    static int n,m,k;
    static int firstLeaf;
    static int a,b;
    static long c;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //시작 노드 계산
        firstLeaf = 1;
        while(firstLeaf < n) firstLeaf *= 2;
        if(n != 1){ // n이 1인 경우아래의 코드가 실행되면 firstLeaf가 0이 되어버림.
            firstLeaf--;
        }

        //배열에 값 담기 -  리프노드
        arr = new long[firstLeaf * 2];
        for(int i = 0; i < n; i++){
            arr[firstLeaf + i] = Long.parseLong(br.readLine());
        }

        //배열에 값 담기 - 부모
        for(int i = firstLeaf - 1; i >= 0; i--){
            arr[i] = arr[i * 2] + arr[i * 2 + 1];
        }

        //m + k번 동안 명령 실행하기
        for(int i = 0; i < m + k; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            if(a == 1){ //b번째 값을 c로 바꾸기
                edit();
            }else{ //b~c번째 까지의 합 구하기
                sum((int) (b - 1), (int) (c - 1));
            }
        }

    }

    private static void sum(int l, int r) {
        l = firstLeaf + l;
        r = firstLeaf + r;

        long sum = 0;
        while(l <= r){
            //left가 오른쪽 노드면 더해주고, 범위를 좁힘
            if(l % 2 == 1) sum += arr[l++];
            //right가 왼쪽 노드면 더해주고, 범위를 좁힘
            if(r % 2 == 0) sum += arr[r--];
            //부모노드로 이동
            l/=2;
            r/=2;
        }
        System.out.println(sum);
    }

    private static void edit() {
        int index = firstLeaf + b - 1;
        arr[index] = c;//리프노드의 값변경
        while(index != 0){
            index = index / 2;
            arr[index] = arr[(index * 2)] + arr[(index * 2 + 1)];
        }
    }
}
