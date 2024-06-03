import java.util.*;

class Solution {
    public int solution(int[] a) {
        int cnt = 0;
        int[] minLeft = new int[a.length];
        int[] minRight =new int[a.length];
        //본인 보다 작은 숫자는 단 한번만 터트릴 수 있다. =>양방향으로 본인보다 작은 값은 1개.
        //각 인덱스별로 좌측, 우측의 최소값을 배열에 저장해놓는다.
        //minleft
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < a.length; i++){
            minLeft[i] =  Math.min(min, a[i - 1]);
            min = minLeft[i];
        }
        //minRight
        min = Integer.MAX_VALUE;
        for(int i = a.length - 2; i >= 0; i--){
            minRight[i] = Math.min(min, a[i + 1]);
            min = minRight[i];

        }
        //a[i]값이 minLeft[i], minRight[i] 두개의 값보다 큰 경우 conitnue;else cnt++
        for(int i = 1; i < a.length - 1; i++){
            if(a[i] > minLeft[i] && a[i] > minRight[i]) continue;
            cnt++;
        }
        int answer = cnt + 2;
        return answer;
    }
}