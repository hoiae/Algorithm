import java.util.*;

class Solution {
    static class File implements Comparable<File>{
        String origin;
        String head;
        int number;
        
        public File(String str){
            this.origin = str;
            StringBuilder sb = new StringBuilder();
            
            boolean flag = false;
            for(int i = 0; i < str.length(); i++){
                if(flag && (str.charAt(i) < '0' || str.charAt(i) > '9')){
                    break;
                }
                
                if(!flag && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    flag = true; 
                }
                
                if(flag && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    flag = true;
                    sb.append(str.charAt(i));
                }
            }
            
            this.number = Integer.parseInt(sb.toString());
            this.head = str.split(sb.toString())[0].toUpperCase();
        }
        
        @Override
        public int compareTo(File o){
            if(!this.head.equals(o.head)){
                return this.head.compareTo(o.head);
            }
            return this.number - o.number;
        }
        
        
    }
    public String[] solution(String[] files) {
        File[] arr = new File[files.length];
        for(int i = 0; i < files.length; i++){
            arr[i] = new File(files[i]);
        }
        
        Arrays.sort(arr);
        String[] answer = Arrays.stream(arr).map(i -> i.origin).toArray(String[]::new);
        return answer;
    }
}