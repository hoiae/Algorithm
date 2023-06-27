
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,S;
    static int[] Arr;
    static List<Integer> left = new ArrayList<>();
    static List<Integer> right = new ArrayList<>();
    public static void main(String[] args) throws IOException {
    //배열을 반으로 나눈다.
        //나눈 배열들의 요소들로 만들수있는 부분집합의 합의 값들을 저장한다
    //투 포인터 배열을 활용해서 더한다.
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Arr = new int[N];
        for(int i = 0; i < N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        makeList(0,N/2,0, left);
        makeList(N/2, N,0, right);

        Collections.sort(left);
        Collections.sort(right);

        //두개의 배열을 twopointer로 원하는 값을 찾음
        long cnt = 0;
        int leftIdx = 0;
        int rightIdx= right.size() - 1;
        while(leftIdx < left.size() && rightIdx >= 0){
            int now = left.get(leftIdx) + right.get(rightIdx);
            if(now == S){
                long leftCnt = 0;
                long rightCnt = 0;

                int leftValue = left.get(leftIdx);
                while(leftIdx < left.size() && left.get(leftIdx) == leftValue){
                    leftCnt++;
                    leftIdx++;
                }

                int rightValue = right.get(rightIdx);
                while(rightIdx >= 0 && right.get(rightIdx) == rightValue){
                    rightCnt++;
                    rightIdx--;
                }

                cnt += leftCnt * rightCnt;

            }else if (now < S){
                leftIdx++;
            }else if(now > S){
                rightIdx--;
            }
        }

        if(S == 0){
            cnt--;
        }
        System.out.println(cnt);
    }

    private static void makeList(int start, int end, int sum, List<Integer> list){
        if(start == end){
            list.add(sum);
            return;
        }
        makeList(start + 1, end, sum + Arr[start], list);
        makeList(start + 1, end, sum, list);
    }

}
