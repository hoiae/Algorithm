public class Solution {
    public int solution(int n, int[] cores) {
        if(n <= cores.length){
            return n;
        }
        
        long left = 1;
        long right = 50_000L * 10_000 + 1;
        
        //n개의 작업을 끝내는 시간(lowerbound)를 찾는다.
        while(left < right){
            long mid = (left + right) / 2;
            
            long done = cores.length;
            for(int i = 0; i < cores.length; i++){
                done += mid / cores[i];
            }
            
            if(done >= n){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        //left가 lowerBound;
        long time = left - 1;
        
        //현재까지 몇개의 일을 처리했는지 확인한다.
        long done = cores.length;
        for(int i = 0; i < cores.length; i++){
            done += time / cores[i];
        }
        
        //현재 시간에 작업이 가능한 것들을 찾는다.
        for(int i = 0; i < cores.length; i++){
            if((time + 1) % cores[i] == 0){
                done++;
                if(done == n){
                    return i + 1;
                }
            }
        }
        
        return -1;
        
    }
}
