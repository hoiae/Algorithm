import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            if(map.containsKey(str)){
                int value = map.get(str);
                map.put(str,value + 1);
            }else{
                map.put(str,1);
            }
        }

        String key = null;
        int freq = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() > freq){
                key = entry.getKey();
                freq = entry.getValue();
            }else if(entry.getValue() == freq){
                if(key.compareTo(entry.getKey()) < 0){
                    key = entry.getKey();
                }
            }
        }
        System.out.println(key+" "+freq);
    }
}