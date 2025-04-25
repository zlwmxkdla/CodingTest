import java.util.*;
class Solution {
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean no_target = true;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                no_target = false;
                break;
            }
        }
        if(no_target)return 0;
        
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[]{begin,"0"});
        
        while(!q.isEmpty()){
            String[] now = q.poll();
            if(now[0].equals(target)){
                answer = Integer.parseInt(now[1]);
                break;
            }
            for(int i=0;i<words.length;i++){
                if(one_different(now[0],words[i])){
                    q.add(new String[]{words[i],String.valueOf(Integer.parseInt(now[1])+1)});
                
                }
            }
        }
        return answer;
    }
    public static boolean one_different(String a, String b){//변환 가능한 단어일 경우 true 리턴
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(count>1)return false;
            if(a.charAt(i)!=b.charAt(i))count++;
        }
        if(count==1)return true;
        else return false;
    }
}
