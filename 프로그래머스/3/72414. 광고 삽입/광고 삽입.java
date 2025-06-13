import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        if(play_time.equals(adv_time)){
            return toTimeFormat(0);
        }
        //모든 시간을 second로 계산한다.
        //누적합을 사용한다. -> 해당 시간대에 몇명의 사람이 있는지
        long[] prefixSum = new long[360000 + 1];
        for(String log: logs){
            String[] times = log.split("-");
            int start = toSecond(times[0]);
            int end = toSecond(times[1]);
            prefixSum[start]++;
            prefixSum[end]--;
        }
        //해당 구간에 몇명이 있는지 
        for(int i = 1; i < prefixSum.length; i++){
            prefixSum[i] += prefixSum[i - 1];
        }
        
        //구간합을 구하기 위한 누적합
        for(int i = 1; i < prefixSum.length; i++){
            prefixSum[i] += prefixSum[i - 1];
        }
        
        //adv_time을 기준으로 구간합을 찾는다. -> 슬라이딩 윈도우
        int playTimeSecond = toSecond(play_time);
        int advTimeSecond = toSecond(adv_time);
        long max = Long.MIN_VALUE;
        long startTime = 0;
        for (int i = 0; i <= playTimeSecond - advTimeSecond; i++) {
            long currentTime;
            if (i == 0) {
                currentTime = prefixSum[advTimeSecond - 1]; // 0 ~ advTime-1
            } else {
                currentTime = prefixSum[i + advTimeSecond - 1] - prefixSum[i - 1];
            }

            if (currentTime > max) {
                max = currentTime;
                startTime = i;
            }
        }

        // for(int i = 0; i < prefixSum.length - advTimeSecond; i++){
        //     long currentTime = prefixSum[advTimeSecond + i] - prefixSum[i];
        //     if(currentTime > max){
        //         max = currentTime;
        //         startTime = i + 1;
        //     }
        // }
        String answer = toTimeFormat(startTime);
    
        return answer;
    }
    private String toTimeFormat(long time){
        long h = time / 3600;
        long m = (time % 3600) / 60;
        long s = time % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
    private int toSecond(String time){
        int[] hms = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return (hms[0] * 3600) + (hms[1] * 60) + hms[2];
    }
}