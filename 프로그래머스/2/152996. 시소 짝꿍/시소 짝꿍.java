import java.util.*;
/*
2,3,4미터 -> 최대 공약수가 2,3 인경우를 찾는다. 모든 경우의 수가 어떻게 될것인 가? 
100 100 180 270 360

1. 2개를 고르는 모든 조합을 구한다.
=> 100,000 n! / (n - r)! / r!
2. 2, 3, 4를 
*/
class Solution {
    static int[] counts;
    static int[] originCnt;
    static int n;
    public long solution(int[] weights) {
        n = weights.length;
        counts = new int[4000 + 1];
        originCnt = new int[4000 + 1];
        long ans = 0;
        
        
        for(int i = 0; i <  n; i++){
            int value = weights[i];
            int dupCnt = originCnt[value];
            int v2 = value * 2;
            int v3 = value * 3;
            int v4 = value * 4;
            
            
            if(dupCnt > 0){
                //같은 몸무게가 있는 경우
                ans += dupCnt;
                ans += counts[v2] - dupCnt;
                ans += counts[v3] - dupCnt;
                ans += counts[v4] - dupCnt;
            }else{
                //같은 몸무게가 없는 경우
                ans += counts[v2];
                ans += counts[v3];
                ans += counts[v4];
            }
            
            originCnt[value]++;
            counts[v2]++;
            counts[v3]++;
            counts[v4]++;
        }
        
      
        return ans;
    }
}