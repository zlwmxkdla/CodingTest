import java.util.*;

class Solution {
    static boolean[]visited;
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        if(!set.contains(target))return 0;
        
        
        for(int i=0;i<words.length;i++){
            
            if(can_change(begin, words[i])){
               visited = new boolean[words.length];
                visited[i]=true; 
                dfs(words[i],target,words, 1);
            }
            
        }
        
        return answer;
    }
    
    public void dfs(String begin, String target, String[]words, int depth){
        if(begin.equals(target)){
            answer = Math.min(answer,depth);
            return;
        }
        for(int i=0;i<words.length;i++){
            if(!visited[i]&&can_change(begin,words[i])){
                visited[i]=true;
                dfs(words[i],target,words,depth+1);
                visited[i]=false;
            }
        }
    }
    
    
    
    public boolean can_change(String a, String b){
        int count = 0;//다른 알파벳의 개수
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))count+=1;
            if(count>1)return false;
        }
        if(count==0)return false;
        return true;
    }
}