class Solution {
    static String[] user_id;
    static String[] banned_id;
    static int N,K;
    static String[] arr;
    static boolean[] visited;
    static boolean[] banVisited;
    static boolean dfsEnd;
    static int cnt;
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        
        N = user_id.length;
        K = banned_id.length;
        
        arr = new String[K];
        visited = new boolean[N];
        banVisited = new boolean[K];
        
        combi(0,0);//nCk
        
        return cnt;
        
        //조합으로 banned_id.length만큼 user_id를 뽑음
        //뽑은것들을 banned_id와 dfs를 통해 매칭함.
        
    }
    private static void combi(int index, int depth){
        if(depth == K){
            //dfs로 banned_id와 매칭함.
            // for(int i = 0; i < K; i++){
            //     System.out.print(arr[i]+" ");
            // }
            // System.out.println("dfs 매칭시작");

            dfsEnd = false;
            dfs(0,0);
            return;
        }
        
        for(int i = index; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = user_id[i];
            combi(i + 1, depth + 1);
            visited[i] = false;
        }
    }
    
    private static void dfs(int userIndex, int depth){
        if(dfsEnd) return;
        if(depth == K){
            dfsEnd = true;
            cnt++;
            return;
        }
        

        for(int i = 0 ; i < K ; i++){
            if(banVisited[i]) continue;
            banVisited[i] = true;
            if(compare(arr[userIndex], banned_id[i])){
                dfs(userIndex + 1, depth + 1);                
            }
            banVisited[i] = false;
        }

    }
    
    private static boolean compare(String user, String ban){
        if(ban.length() != user.length()) return false;
        
        for(int i = 0; i < ban.length(); i++){
            if(ban.charAt(i) == '*') continue;
            if(ban.charAt(i) != user.charAt(i)) return false;
        }
        
        return true;
    }
   
}