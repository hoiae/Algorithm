import java.util.*;

class Solution {
    static class Info implements Comparable<Info>{
        String name;
        int startTime;
        int cost;
        
        public Info(String name, String startTime, String cost){
            this.name = name;
            this.startTime = timeConvert(startTime);
            this.cost = Integer.parseInt(cost);
        }
        
        public static int timeConvert(String time){
            String[] times = time.split(":");
            return (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);
        }
        
        public int compareTo(Info o){
            return Integer.compare(this.startTime,o.startTime);
        }
        
        public String toString(){
            return "[name= "+this.name +", startTime= "+ this.startTime +", cost= " + this.cost+"]";
        }
        
    }
    public String[] solution(String[][] plans) {
        //전처리, 시작 시간으로 정렬한다.
        Info[] infos = new Info[plans.length];
        
        for(int i = 0; i < plans.length; i++){
            infos[i] = new Info(plans[i][0] , plans[i][1] , plans[i][2]);
        }
        
        
        Arrays.sort(infos);  
        //끝내지 못한 작업을 담는 스택
        Stack<Info> stack = new Stack<>();
        
        int index = 0;
        List<String> answer = new ArrayList<>();

        //infos에서 i ~ infos.length까지 반복한다
        for(int i = 0;  i < infos.length - 1; i++){
            Info now = infos[i];
            Info next = infos[i + 1];
            int endTime = now.startTime + now.cost;
            //i + 1과 비교한다.
            //i + 1의 시작 시간보다 i의 시작+소모시간이 작은 경우
            if(endTime < next.startTime){
                //업무가 완료된 경우이므로, name을 ans[]에 넣는다.
                answer.add(now.name);
                //stack에 값이 있는 경우 위와 같은 내용을 반복함.
                int restTime = next.startTime - endTime;
                while(restTime > 0 && !stack.isEmpty()){
                    Info info = stack.pop();
                    if(info.cost <= restTime){
                        restTime -= info.cost;
                        answer.add(info.name);
                    }else{
                        info.cost -= restTime;
                        stack.push(info);
                        break;
                    }                
                }
            }
            //종료시간이 다음 시작시간을 넘기는 경우
            else if(endTime > next.startTime){
                now.cost -= next.startTime - now.startTime;
                stack.push(now);
                continue;
            }
            //다음 시작시간과 종료시간이 정확히 일치하는 경우
            else if(endTime == next.startTime){
                answer.add(now.name);
            }
        }
        
        //마지막값 넣음
        answer.add(infos[infos.length - 1].name);
        
        //stack에 남아있는 작업 처리
        while(!stack.isEmpty()){
            answer.add(stack.pop().name);
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}