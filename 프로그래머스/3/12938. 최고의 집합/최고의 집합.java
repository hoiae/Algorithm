class Solution {
    public int[] solution(int n, int s) {
        int[] ans = new int[n];
        if(n > s){
         return new int[]{-1};
        }
        
        
        int q = s / n;
        int r = s % n;
        
        for(int i = 0; i < n; i++){
            ans[i] = q;
        }
        
        for(int i = 0; i < r ; i++){
            ans[n - i - 1]++;
        }
            
        return ans;
    }
}