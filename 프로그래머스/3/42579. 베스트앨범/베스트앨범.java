import java.util.*;
import java.util.Map.Entry;
class Solution {
    public static class Info implements Comparable<Info>{
        int number;
        int play;
    
        public Info(int number, int play){
            this.number = number;
            this.play = play;
        }
        @Override
        public int compareTo(Info i){
            return Integer.compare(this.play, i.play);
        }
        
    
        
    }
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String,Integer> genreMap = new HashMap<>();//장르반환 순서 결정

        
        for(int i = 0; i < genres.length; i++){
            if(genreMap.containsKey(genres[i])){
                genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);

            }else{
                genreMap.put(genres[i], plays[i]);
            }
        }
        
        List<String> gen = new ArrayList<>(genreMap.keySet());
        
        //장르별 재생수를 내림차순 정렬함.
        Collections.sort(gen, (o1,o2)->{
                return genreMap.get(o2) - genreMap.get(o1);  
            }
        );
        
        
        
        List<Integer> answer = new ArrayList<>();
        for(String gr : gen){
            List<Info> list = new ArrayList<>();
            for(int i = 0; i < genres.length; i++){
                String now = genres[i];
                if(now.equals(gr)){
                    list.add(new Info(i, plays[i]));
                }
            }
            
            Collections.sort(list, Collections.reverseOrder());
            
            for(int i = 0; i < 2 && i < list.size(); i++){
                answer.add(list.get(i).number);
            }
        }
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}