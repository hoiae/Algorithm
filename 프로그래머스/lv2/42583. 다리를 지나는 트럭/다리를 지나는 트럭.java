import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1; //계속해서 증가시켜주는 변수가 필요함.
        int total_weight = 0;
        Queue<Info> q = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++){

            System.out.println("i: " + i);
            while(q.size() >= bridge_length  || total_weight + truck_weights[i] > weight){
                 if(q.peek().startTime + bridge_length > time){
                    time += q.peek().startTime + bridge_length - time;
                }
                total_weight -=  q.poll().weight;
            }

                q.add(new Info(truck_weights[i],time));
                total_weight += truck_weights[i];
                time++;
        }
        time += bridge_length;
        
        return time - 1;
    }
    static class Info{
        int weight;
        int startTime;
        
        public Info(int weight, int startTime){
            this.weight = weight;
            this.startTime = startTime;
        } 
    }
}