import java.util.*;

class Solution {
    static int[] time;
    static int n,t,m;
    public String solution(int n, int t, int m, String[] timetable) {
        //timetable 정렬
        this.n = n;
        this.t = t;
        this.m = m;
        //n번 09:00부터 t마다 m명씩 제외함.(09:00+t <= timetable[]) 
        time = new int[timetable.length];
        //int형으로 timetable변환
        for(int i = 0; i < time.length; i++){
            time[i] = Integer.parseInt(timetable[i].replace(":",""));
            if(time[i] % 100 >= 60){
                time[i] += 40;
            }
        }
        //정렬
        Arrays.sort(time);
        // for(int i = 0; i < time.length; i++){
        //     System.out.print(time[i]+" ");
        // }
        // System.out.println();
        // solve();
        
        return solve();
    }
    private static String solve(){
        int departureTime = 900;
        int lastIndex = 0;
        boolean isEmpty = false;
        
        for(int i = 0; i < n; i++){
            isEmpty = false;//마지막 회차에서 확인해야함.
            if(i >= 1){
                departureTime += t;
                if(departureTime% 100 >= 60){
                    departureTime += 40;
                }
            }
            // System.out.println("i= " + i +" departureTime="+departureTime);
            //버스에 태우기
            int end = lastIndex + m;
            for(int c = lastIndex;  c < end; c++){
                // System.out.println("현재 크루의 인덱스c =" + c);
                //사람이 없는 경우
                if(c >= time.length){
                    // System.out.println("isEmpty = true");
                    isEmpty = true;
                    break;
                }
                //출발시간보다 늦게 도착한 경우
                if(time[c] > departureTime){
                    // System.out.println("출발시간보다 늦은 경우");
                    if(i == n - 1){
                        isEmpty = true;
                    }
                    break;
                }
                lastIndex++;
            }
        }
        
        int ans = 0;
        if(isEmpty || lastIndex == 0){
            ans = departureTime;
        }else{
            ans = time[lastIndex-1] - 1;
        }
        return format(ans);
    }
    
    private static String format(int ans){
        if(ans % 100 >= 60){
            ans -= 40;
        }
        
        char[] temp = new char[4];
        for(int i = 0; i < 4; i++){
            temp[i] = '0';
        }
        
        String time = String.valueOf(ans);
        int index = 3;
        
        for(int i = time.length() - 1; i >= 0; i--){
            temp[index--] = time.charAt(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(temp[0]).append(temp[1]).append(":").append(temp[2]).append(temp[3]);
        return sb.toString();
    }
}