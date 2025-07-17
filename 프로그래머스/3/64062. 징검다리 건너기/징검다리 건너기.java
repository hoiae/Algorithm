class Solution {
    static int[] stones;
    public int solution(int[] stones, int k) {
        this.stones = stones;
        //연속된 0의 길이가 k를 초과하면 종료
    
        int l = 1;
        int r = 200_000_000;
        
        int answer = 0;
        while(l <= r){
            int mid = (l + r)/2;
            if(calculate(mid, k)){
                answer = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        
        return answer;
    }
    private boolean calculate(int num, int k){
        int cnt = 0;
        for(int i = 0; i < stones.length; i++){
            if(stones[i] < num){
                cnt++;
                if(cnt == k) return false;
            }else{
                cnt = 0;
            }
        }
        return true;
    }
}