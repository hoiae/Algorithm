import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static BufferedReader br;
    static StringBuilder result;
    static int[][] relation;
    static String[] words;
    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#" +test_case+ " "+solve()+"\n");
        }
        System.out.println(sb);
    }

    private static String solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        words = new String[n + 1];
        relation = new int[n + 1][2]; //[][0]왼쪽, [][1]오른쪽
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            String word = st.nextToken();
            int left = -1;
            int right = -1;
            if (st.hasMoreTokens()) {
                left = Integer.parseInt(st.nextToken());
            }
            if(st.hasMoreTokens()){
                right = Integer.parseInt(st.nextToken());
            }
            words[index] = word;
            if(left != -1){
                relation[index][0] = left;
            }
            if(right != -1){
                relation[index][1] = right;
            }

        }
        //루트 노드는 항상 1이다.
        result = new StringBuilder();

        inOrder(1);
        return result.toString();
    }

    private static void inOrder(int index) {
        if(words[index] == null){
            return;
        }
        //왼
        inOrder(relation[index][0]);
        //나
        result.append(words[index]);
        //오
        inOrder(relation[index][1]);
    }
}