import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> unavailableNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int unavailableCount = Integer.parseInt(br.readLine());
        if (unavailableCount != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < unavailableCount; i++) {
                unavailableNumbers.add(Integer.parseInt(st.nextToken()));
            }
        }

        int theClosestNumber = getTheClosestNumber(target);
        showNumberOf(theClosestNumber, target);
    }

    private static void showNumberOf(int theClosestNumber, int target) {
        if(unavailableNumbers.size() == 10){
            System.out.println(Math.abs(target - 100));
            return;
        }
        int length = Integer.toString(theClosestNumber).length();
        int error = Math.abs(target - theClosestNumber);

        int result1 = length + error;
        int result2 = Math.abs(target - 100);

        System.out.println(result1 < result2 ? result1 : result2);
    }

    private static int getTheClosestNumber(int target) {
        int small = findSmallerNumber(target);
        int big = findBiggerNumber(target);
        if(small < 0) return big;
        return Math.abs(big - target) < Math.abs(small - target) ? big : small;

    }

    private static int findSmallerNumber(int target) {
        int currNumber = target;
        point:
        while (currNumber >= 0) {
            String[] temp = Integer.toString(currNumber).split("");
            for (int i = 0; i < temp.length; i++) {
                if (unavailableNumbers.contains(Integer.parseInt(temp[i]))) {
                    currNumber--;
                    break;
                }
                if (i == temp.length - 1)
                    break point;
            }
        }
        return currNumber;
    }

    private static int findBiggerNumber(int target) {
        int currNumber = target;
        point:
        while (currNumber <= 999999) {
            String[] temp = Integer.toString(currNumber).split("");
            for (int i = 0; i < temp.length; i++) {
                if (unavailableNumbers.contains(Integer.parseInt(temp[i]))) {
                    currNumber++;
                    break;
                }
                if (i == temp.length - 1)
                    break point;
            }
        }
        return currNumber;
    }
}