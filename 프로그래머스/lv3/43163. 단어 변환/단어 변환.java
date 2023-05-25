import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        //변환할 수 없는 경우, 해당 배열에 target이 들어있지 않은 경우
        int targetIndex = Arrays.asList(words).indexOf(target);
        // System.out.println(targetIndex);
        if(targetIndex == -1){
            return 0;
        }
        
        
        //bfs
            //타겟단어가 되면 종료,
            //바뀐횟수, 단어를 담는 클래스필요
        boolean[] visited = new boolean[words.length];
        Deque<Info> dq = new ArrayDeque<>();
        dq.add(new Info(begin,-1,0));
        int answer = 0;
        
        while(!dq.isEmpty()){
            Info now = dq.poll();
            if(now.word.equals(target)){
                answer = now.cnt;
            }
            
            for(int i = 0; i<words.length; i++){
                if(visited[i] == true) continue;
                String comparedword = words[i];
                int cnt = 0;
                for(int j = 0; j < now.word.length(); j++){
                    if(now.word.charAt(j) == comparedword.charAt(j)){
                        cnt++;
                    }
                }
                if(now.word.length() - 1 == cnt){
                    dq.add(new Info(comparedword,i,now.cnt + 1));
                    visited[i] = true;
                }
            }
        }
        return answer;
    }
    static class Info{
        String word;
        int index;
        int cnt;
        public Info(String word,int index, int cnt){
            this.word = word;
            this.index = index;
            this.cnt = cnt;
        }
    }
}