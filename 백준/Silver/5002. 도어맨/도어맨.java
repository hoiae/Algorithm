import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());//최대로 허용되는 차이
        String line = br.readLine();
        
        int wCnt = 0;
        int mCnt = 0;
        
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < line.length(); i++){
        
            //q가 있으면 q를 먼저 파악한다.
            if(!q.isEmpty()){
                if(q.peek() == 'W'){
                //w인 경우
                    //입장했을때의 차이가 m보다 작거나 같은 경우 입장
                    if(Math.abs(wCnt + 1 - mCnt) <= m){
                        wCnt++;
                        q.poll();
                    }
                }else{
                //m인 경우 경우
                    if(Math.abs(mCnt + 1 - wCnt) <= m){
                        mCnt++;
                        q.poll();
                    }
                }
            }
            //다음순서를 찾는다.
            if(line.charAt(i) == 'M'){
                if(Math.abs((mCnt + 1) - wCnt) <= m){
                    mCnt++;
                }else if(q.isEmpty()){
                    q.add('M');
                }else{
                    break;
                }
            }else{
                if(Math.abs((wCnt + 1) - mCnt) <= m){
                    wCnt++;
                }else if(q.isEmpty()){
                    q.add('W');
                }else{
                    break;
                }
                
            }
        }
        System.out.println((mCnt+wCnt));
    }
}
