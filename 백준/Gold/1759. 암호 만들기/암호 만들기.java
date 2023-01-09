
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int l;
    static int c;
    static char[] alphabet;
    static boolean[] visit;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        //L 암호를 구성하는 서로 다른 알파벳 개수
        //a e i o u 중 1개 + 자음2개 미니멈
        //오름차순배열
        //C 문자의 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        alphabet = new char[c];
        visit = new boolean[c];
        arr = new char[l];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < c; i++){
            alphabet[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabet);
        solve(0,0);
        System.out.println(sb);

    }
    private static void solve(int index,int depth) {
        if(depth == l){
            if(!checkCondition()){
                return;
            }
            for(int i = 0; i < depth; i++){
                sb.append(arr[i]);
            }
            sb.append("\n");
            return;
        }
        for(int i = index;  i < c; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = alphabet[i];
                solve(i,depth + 1);
                visit[i] = false;
            }
        }
    }

    private static boolean checkCondition() {
        int vowels = 0;
        for(int i = 0; i < arr.length; i++){
            char alph = arr[i];
            if(alph =='a'|| alph =='e' || alph == 'i' || alph == 'o'|| alph == 'u'){
             vowels++;
            }
        }
        int consonant = l - vowels;
        if( vowels >= 1 && consonant >=2)
            return true;
        return false;
    }
}
