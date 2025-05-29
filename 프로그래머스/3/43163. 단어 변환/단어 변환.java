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
        int answer = 0;
        boolean[]visited = new boolean[words.length];
        Queue<wordstats> q = new LinkedList<>();
        q.add(new wordstats(0,begin));
        
        while(!q.isEmpty()){
            wordstats now = q.poll();
            if(now.word.equals(target))return now.cnt;
            for(int i=0;i<words.length;i++){
                if(!visited[i]&&canchange(words[i],now.word)){
                    visited[i]=true;
                    q.add(new wordstats(now.cnt+1,words[i]));
                }
            }
        }
        return answer;
    }
    public static boolean canchange(String a,String b){
        int cnt = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))cnt++;
        }
        if(cnt==1)return true;
        else return false;
    }
}