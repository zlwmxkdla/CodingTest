import java.util.*;
class Solution {
    class wordstats{
        int cnt;
        String word;
        wordstats(int cnt,String word){
            this.cnt=cnt;
            this.word=word;
        }
    }
    public int solution(String begin, String target, String[] words) {
        Queue<wordstats> q= new LinkedList<>();
        q.add(new wordstats(0,begin));
        boolean[]visited = new boolean[words.length];
        
        while(!q.isEmpty()){
            wordstats now = q.poll();
            if(now.word.equals(target))return now.cnt;
            
            for(int i=0;i<words.length;i++){
                if(!visited[i]){
                    
                    if(canchange(now.word,words[i])){
                        visited[i]=true;
                        q.add(new wordstats(now.cnt+1,words[i]));
                    }
                }
            }
        }
        return 0;
    }
    public boolean canchange(String a, String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))count+=1;
        }
        if(count==1)return true;
        else return false;
    }
}