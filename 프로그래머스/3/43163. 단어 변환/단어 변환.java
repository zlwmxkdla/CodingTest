import java.util.*;
class Solution {
    class wordstats{
        int num;
        String s;
        wordstats(int num,String s){
            this.num=num;
            this.s=s;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[]visited = new boolean[words.length];
        Queue<wordstats> q = new LinkedList<>();
        q.add(new wordstats(0,begin));
        //visited[0]=true;//begin 단어는 시작점에 없음
        
        while(!q.isEmpty()){
            wordstats now = q.poll();
            if(now.s.equals(target))return now.num;
            
            for(int i=0;i<words.length;i++){
                if(!visited[i]&&canchange(now.s,words[i])){
                    visited[i]=true;
                    q.add(new wordstats(now.num+1,words[i]));
                    
                }
            }
            
        }
        return answer;
    }
    public static boolean canchange(String a, String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))count+=1;
        }
        if(count==1)return true;
        else return false;
    }
}