import java.util.*;
class Solution {
    static int answer;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        answer = 0;
        char[] words = numbers.toCharArray();
        boolean[]visited = new boolean[words.length];
        for(int i=1;i<=numbers.length();i++){
            dfs(i,visited,"",words);
        }
        return set.size();
    }
    public static void dfs(int size, boolean[]visited,String word,char[]words){
        if(word.length()==size){
            
            if(isPrime(Integer.parseInt(word))){
                set.add(Integer.parseInt(word));
            }
            return;
        }
        for(int i=0;i<words.length;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(size,visited,word+words[i],words);
                visited[i]=false;
            }
        }
    }
    public static boolean isPrime(int n){
        if(n==1)return false;
        else if(n==0)return false;
        else if(n==2)return true;
        else if(n==3)return true;
        else{
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0)return false;
            }
            return true;
        }
    }
}