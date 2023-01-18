
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int max;
    static List arr = new ArrayList();
    static int ptr = 0;
    static int[] allarr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        String commend;
        int number;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            commend = st.nextToken();
            number = 0;
            if (st.hasMoreTokens()) {
                number = Integer.parseInt(st.nextToken());
            }
            calculate(commend, number);
        }
        System.out.println(sb);
    }

    private static void calculate(String commend, int number) {
        switch (commend) {
            case "add":
                addFunction(number);
                break;
            case "check":
                checkFunction(number);
                break;
            case "remove":
                removeFunction(number);
                break;
            case "toggle":
                toggleFunction(number);
                break;
            case "all":
                allFunction();
                break;
            case "empty":
                emptyFunction();
                break;

        }
    }

    private static void emptyFunction() {
        arr.clear();
    }

    private static void allFunction() {
//        arr = Arrays.asList(allarr);
//        arr.clear();
//        arr.addAll(Arrays.asList(allarr));
        for (int i = 0; i < 20; i++) {
            if (i >= arr.size()) {
                arr.add(i, i + 1);
            } else {
                arr.set(i, i + 1);
            }
        }
    }


    private static void toggleFunction(int number) {
        if (!arr.contains(number)) {
//            System.out.println(number);
//            System.out.println(arr.contains(number));
            arr.add(number);
        } else {
            int index = arr.indexOf(number);
            arr.remove(index);

        }
    }

    private static void removeFunction(int number) {
        int index = arr.indexOf(number);
        if (index >= 0) {
            arr.remove(index);
        }
    }

    private static void checkFunction(int number) {
        if (arr.contains(number)) {
            sb.append(1);
        } else {
            sb.append(0);
        }
        sb.append("\n");
    }

    private static void addFunction(int number) {
        arr.add(number);
//        arr[ptr++] = number;
    }
}
