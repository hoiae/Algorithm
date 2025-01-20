class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // 틀린경우,
        // time_cur 만큼의 시간을 사용한다.
        // time_prev만큼의 시간을 소모하여, 이전 퍼즐을 다시 풀고와야한다.
        
        // 퍼즐게임에는 전체 제한 시간 limit이 정해져 있다.
        // 제한 시간내에 퍼즐을 모두 해결하기 위해서 숙련도의 "최솟값"을 구해야한다.
        int answer = Integer.MAX_VALUE;;
        
        //diffs를 기준으로한다.
        int left = 1;
        int right = 100_000;
        
        //이분탐색
        while(left <= right){
            int level = (left + right) / 2;
            
            long result = solve(diffs, times, level,limit);
            if(result == -1){
                //-1인경우는 limit을 초과한 것이므로 level을 더 높여야한다.
                left = level + 1;
            }else{
                //정상적으로 동작한 경우, level을더 낮춘다.
                answer = Math.min(answer, level);
                right = level - 1;
            }
 
        }
        return answer;
    }
    private long solve(int[] diffs, int[] times, int level, long limit){
        long spend = 0;
        
        //순차적으로 진행한경우
        for(int i = 0 ; i < diffs.length; i++){            
            //level을 parameter를 인자로 받아서 로직 진행
            if(diffs[i] <= level){
                spend += times[i];
            }else{
                int count = diffs[i] - level; //이전 문제 + 현재 문제를 다시 풀어야하는 횟수;
                spend += count * (times[i - 1] + times[i]);//반복되는 시간
                spend += times[i];//현재 문제를 정상적으로 푼다.
            }
        }
        
        //limit을 초과한 경우 종료시킨다.
        if(spend > limit){
            return -1; // -1를 return한 경우 인자인 level을 높여야한다. 낮추면 또 실패하기 때문
        }
        
        return spend; //정상적으로 return된 경우 이므로 인자인 leve을 낮춘다.
    }
}