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
        //어떤 장르가 가장많이 재생 됬는지 파악해야함.
        //장르별 재생수를 파악하여 정렬해야함
        //장르순서별로, 재생수가 많은 최대 2개의 고유번호를 반환해야함
        
        Map<String,Integer> genreMap = new HashMap<>();//장르반환 순서 결정

        
        for(int i = 0; i < genres.length; i++){
            if(genreMap.containsKey(genres[i])){
                genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);

            }else{
                genreMap.put(genres[i], plays[i]);
            }
        }
        
        List<Entry<String,Integer>> gen = new ArrayList<Entry<String,Integer>>(genreMap.entrySet());
        
        //장르별 재생수를 오름차순으로 정렬함.
        Collections.sort(gen, new Comparator<Entry<String,Integer>>(){
            @Override
            public int compare(Entry<String,Integer> e1, Entry<String,Integer> e2){
                return Integer.compare(e2.getValue(), e1.getValue());
            }
        });
        
        
        
        List<Integer> answer = new ArrayList<>();
        for(Map.Entry<String,Integer> entry :  gen){
            String key = entry.getKey();
            System.out.println(key);
            List<Info> list = new ArrayList<>();
            for(int i = 0;  i < genres.length; i++){
                if(genres[i].equals(key)){
                    list.add(new Info(i,plays[i]));
                }
            }
            Collections.sort(list, Collections.reverseOrder());
            for(int i = 0 ; i < list.size() && i < 2; i++){
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