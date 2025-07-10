import java.util.*;

class Solution {
    static Set<Long> useRooms;
    static Map<Long, Long> books;
    public long[] solution(long k, long[] room_number) {
    
        List<Long> result = new ArrayList<>();
        books = new HashMap<>();
        
        for(long number : room_number){
            result.add(find(number));
        }
        
        long[] answer = result.stream().mapToLong(i->i).toArray();
        return answer;
    }
    
    private long find(long number){
        //가지고 있지 않는 경우
        if(!books.containsKey(number)){
            books.put(number,number + 1);
            return number;
        }
        
        long next = find(books.get(number));
        books.put(number, next + 1);
        return next;
        
        
    }
   
}