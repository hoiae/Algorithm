import java.util.*;

class Solution {
    static int[][] users;
    static int[] emoticons;
    static int[] discounts;
    static PriorityQueue<int[]> pq;
    public int[] solution(int[][] users, int[] emoticons) {
        //서비스 가입자 최대
        //판매액
        
        //n명의 카카오톡 사용자들에게 m개를 할인해서 판매
        
        //할인율 10,20,30,40 중 하나
        
        //이모티콘 구입 or 이모티콘 플러스에 가입
        //일정비율이상 할인하면 구매 -> 구매 비용의 합이 기준에 도달하면, 구입 취소x 임티플 가입
        
        //임티 4^7
        this.users = users;
        this.emoticons = emoticons;
        discounts = new int[emoticons.length];
        pq = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]){
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        
        dfs(0);
        
        int[] answer = pq.poll();
        return answer;
    }
    private void dfs(int depth){
        if(depth == emoticons.length){
            //계산
            calculate();
            return;
        }
        
        for(int i = 1; i <= 4; i++){
            discounts[depth] = i * 10;
            dfs(depth + 1);
        }
        
    }
    
    private void calculate(){
        int total = 0;
        int imCnt = 0;
        //모든 회원 -> 이모티콘
        for(int[] user : users){
            int percent = user[0];
            int price = user[1];
            int sum = 0;
            for(int i = 0; i < emoticons.length; i++){
                if(discounts[i] >= percent){
                //구입한다.
                    sum += emoticons[i] * (1 - (discounts[i] * 0.01));
                }
            }
            //구매하는지 임티플사는지
            if(sum >= price){
                imCnt++;
            }else{
                total += sum;
            }
        }
        
        pq.add(new int[]{imCnt, total});
    }
    
}