import java.util.*;

class Solution {
    static class Trie{
        HashMap<Character, Trie> child = new HashMap<>();
        boolean isEnd;
        int cnt = 0;
        
        public void insert(String str){
            Trie node = this;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                
                node.child.putIfAbsent(c,new Trie());
                node = node.child.get(c);
                node.cnt++;
                
                if(i == str.length()-1){
                    isEnd = true;
                }
            }
        }
        
        public int contains(String str){
            Trie node = this;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                node = node.child.get(c);
                if(node.cnt == 1){
                    return i + 1;  
                }
            }
            return str.length();
        }
    }
    public int solution(String[] words) {
        Trie trie = new Trie();
        for(int i = 0; i< words.length; i++){
            trie.insert(words[i]);
        }
        
        int cnt = 0;
        for(int i = 0; i< words.length; i++){
            cnt += trie.contains(words[i]);
        }
        
        return cnt;
    }
}