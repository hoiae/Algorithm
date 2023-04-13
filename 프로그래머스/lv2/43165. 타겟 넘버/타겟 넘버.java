class Solution {
    static int n;
    static int cnt;
    static int target;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        this.target = target;
        solve(0, 0, numbers); //인덱스, 값, 배열
        return cnt;
    }
    
    private static void solve(int depth, int val, int[] numbers){
        if(depth == n){
            if(val == target){
                cnt++;
            }
            return;
        }
        solve(depth + 1, val + numbers[depth], numbers);
        solve(depth + 1, val - numbers[depth], numbers);
        
    }
}