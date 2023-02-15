
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//두 배열의 합
public class Main {
    static long t;
    static int n, m;
    static int[] A, B;
    static long[] sumA, sumB;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Long.parseLong(br.readLine());

        //A입력
        n = Integer.parseInt(br.readLine());
        A = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //B입력
        m = Integer.parseInt(br.readLine());
        B = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }


        //A배열, B배열의  부배열의 합을 저장함.
        makeSumArray();

        // sumA,B정렬
        Arrays.sort(sumA);
        Arrays.sort(sumB);

//        System.out.println(Arrays.toString(sumA));
//        System.out.println(Arrays.toString(sumB));

        //A부 + B부가  T인 값을 찾음
        for (int i = 0; i < sumA.length; i++) {
            long currentA = sumA[i];
            long key = t - currentA;

            count += (upperBound(key) - lowerBound(key));
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        //B부의 요소가 여러개일수 있으니 동일한 개수 확인

    }

    private static long lowerBound(long currentB) {
        int left = 0;
        int right = sumB.length;
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (currentB > sumB[mid]) {
                left = mid + 1;
            }//중복원소에 값은 여기에 해당됨.
            else {
                right = mid;
            }
        }
//        System.out.println("down: "+left);
        return left;
    }

    private static long upperBound(long currentB) {
        int left = 0;
        int right = sumB.length;

        //left와 right가 같아질떄 까지 반복
        while (left < right) {
            int mid = left + ((right - left) / 2);

            //key값이 mid위치의 값 보다 작은 경우
            if (currentB < sumB[mid]) {
                right = mid;
            }
            // 중복 원소의 경우 else에서 처리됨
            else {
                left = mid + 1;
            }
        }

//        System.out.println("up: "+ left);
        return left;
    }

    private static void makeSumArray() {
        sumA = new long[n * (n + 1) / 2];
        int indexA = 0;
        for (int i = 0; i < n; i++) {
            sumA[indexA++] = A[i];
            for (int j = i + 1; j < n; j++) {
                long tmp1 = sumA[indexA - 1];
                long tmp2 = A[j];
                sumA[indexA++] += tmp1 + tmp2;
//                sumA[indexA++] += sumA[indexA - 1] + A[j];
            }
        }


        sumB = new long[m * (m + 1) / 2];
        int indexB = 0;
        for (int i = 0; i < m; i++) {
            sumB[indexB++] = B[i];
            for (int j = i + 1; j < m; j++) {
                long tmp1 = sumB[indexB - 1];
                long tmp2 = B[j];
                sumB[indexB++] += tmp1 + tmp2;
//                sumB[indexB++] += sumB[indexB - 1] + B[j];
            }
        }


    }
}
