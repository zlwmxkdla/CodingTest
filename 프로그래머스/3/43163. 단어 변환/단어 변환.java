import java.util.*;
class Solution {
    class wordstats{
        int cnt;
        String word;
        wordstats(String word,int cnt){
            this.cnt=cnt;
            this.word=word;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[]visited = new boolean[words.length];
        Queue<wordstats> q = new LinkedList<>();
        q.add(new wordstats(begin,0));
        
        while(!q.isEmpty()){
            wordstats now = q.poll();
            if(now.word.equals(target))return now.cnt;
            for(int i=0;i<words.length;i++){
                if(!visited[i]&&canchange(words[i],now.word)){
                    visited[i]=true;
                    q.add(new wordstats(words[i],now.cnt+1));
                }
            }
        }
        
        return answer;
    }
    public boolean canchange(String a,String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))count+=1;
            
        }
        if(count==1)return true;
        return false;
    }
}