import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static Set<String> visit; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visit= new HashSet<>();
        n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for(int i = 0; i < n; i++){
            words[i] = br.readLine();
            visit.add(words[i]);
        }
        
        m = Integer.parseInt(br.readLine());
        String[] candidates = new String[m];
        for(int i = 0; i < m; i++){
            candidates[i] = br.readLine();
        }
        
        char startC=0;
        char endC=0;
        
        for(int i = 0; i < n; i++){
            if(n==1) break;
            if(words[i].equals("?")){
                if(i == 0){
                    endC = words[i+1].charAt(0);
                }else if(i == n-1){
                    startC = words[i-1].charAt(words[i-1].length()-1);
                }else{
                    startC = words[i-1].charAt(words[i-1].length()-1);
                    endC = words[i+1].charAt(0);
                }
            }
        }
        
        
        String ans = null;
        for(String str : candidates){
            if(n == 1){
                ans = str;
                break;
            }
            if(visit.contains(str)) continue;
            if(startC == 0){
                if(endC == str.charAt(str.length()-1)){
                    ans = str;
                }
            }else if(endC == 0){
                 if(startC == str.charAt(0)){
                    ans = str;
                }
            }else{
                 if(startC == str.charAt(0) && endC == str.charAt(str.length()-1)){
                    ans = str;
                }
            }  
        }
        System.out.println(ans);
    }
}
