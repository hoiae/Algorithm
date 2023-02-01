
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//트리순회
public class Main {
    static int n;
    static char child[][] = new char[27][3];
    static boolean visit[] = new boolean[27];
    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            char temp = st.nextToken().charAt(0);
            child[temp - 'A'][0] = temp;
            child[temp - 'A'][1] = st.nextToken().charAt(0);
            child[temp - 'A'][2] =st.nextToken().charAt(0);

        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        System.out.println(sb);
    }

    private static void postOrder(int node) {
        if(node == '.' - 'A')
            return;
        postOrder(child[node][1] - 'A');
        postOrder(child[node][2] - 'A');
        sb.append(child[node][0]);
    }

    private static void inOrder(int node) {
        if(node == '.' - 'A')
            return;
        inOrder(child[node][1] - 'A');
        sb.append(child[node][0]);
        inOrder(child[node][2] - 'A');
    }

    private static void preOrder(int node) {
        if(node == '.' - 'A')
            return;
        sb.append(child[node][0]);
        preOrder(child[node][1] - 'A');
        preOrder(child[node][2] - 'A');

    }
}
