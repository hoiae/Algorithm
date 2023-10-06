
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[n];
        arr[0] = nums[0];

        int[] index = new int[n];//index[a] = b 원본데이터에서 a번째에 있는 숫자는 ,arr배열에 b에 위치힌다.
        index[0] = 0;
//        List<Integer> arr = new ArrayList<>();
//        arr.add(nums[0]);
        int lastIndex = 0;
        for(int i = 1; i < n; i++){
            int now = nums[i];
            if(now > arr[lastIndex]){ //now가 arr의 가장 끝의 숫자보다 큰경우
                lastIndex++;
                arr[lastIndex] = now;
                index[i] = lastIndex;
            }else{//작거나 같은 경우
                //arr의 배열에서 자신보다 큰 것들중 가장 작은 값과 교체함
                int left = 0;
                int right = lastIndex;
                while(left < right){
                    int mid = (left + right) / 2;
                    if(arr[mid] < now){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                arr[left] = now;
                index[i] = left;
            }

        }
        
        int len = lastIndex + 1;
        System.out.println(len);

        int[] result = new int[len];
        for(int i = index.length - 1; i >= 0; i--){
            if(index[i] == lastIndex){
                result[lastIndex] = nums[i];
                lastIndex--;
            }
            if(lastIndex < 0){
                break;
            }
        }
        Arrays.stream(result).forEach(num -> System.out.print(num+" "));
    }
}