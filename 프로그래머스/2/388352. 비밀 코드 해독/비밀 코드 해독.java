import java.util.*;

class Solution {
    static int n;
    static int[][] q;
    static int[] ans;
    static Set<Integer> candidate;
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        //서로다른 5개의 정수 오름차순
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        candidate = new HashSet<>();
        combi(1);
        
        return answer;
    }
    private void combi(int startNum){
        if(candidate.size() == 5){
            //TODO 비교연산
            for(int i = 0; i < q.length; i++){
                int cnt = 0;
                for(int j = 0; j < 5; j++){
                    if(candidate.contains(q[i][j])){
                        cnt++;
                    }
                }
                if(ans[i] != cnt){
                    return;
                }
            }
            answer++;
            return;
        }
        
        for(int num = startNum; num <= n; num++){
            candidate.add(num);
            combi(num + 1);
            candidate.remove(num);
        }
    }
}