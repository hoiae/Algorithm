import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] minArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //i를 증가시키면서 nums[i]가  minArr[i - 1]보다 큰 경우는 추가, 작은 경우는 minArr[]중 nums[i]보다 큰 값중 차이가 가장 조금 나는 값과 대체함
        minArr[0] = nums[0];
        int lastIndex = 0;

        for (int i = 1; i < n; i++) {
            int now = nums[i];

            if (now > minArr[lastIndex]) {
                lastIndex++;
                minArr[lastIndex] = now;
            } else { // minArr[]중 nums[i]보다 큰 값중 차이가 가장 조금 나는 값과 대체함
                int left = 0;
                int right = lastIndex + 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (minArr[mid] < now) {//now보다 작은 경우, 크기를 더 키움
                        left = mid + 1;
                    } else {//now보다 크거나 같은 경우, 가장작은 격차를  가진 값을 찾아야함
                        right = mid;
                    }
                }
                minArr[left] = now;
            }

        }
        System.out.println(lastIndex + 1);
    }
}

