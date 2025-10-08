import java.util.*;
class Solution {
    
    public String solution(String p) {
        String answer = "";
        
        
        
        // 균형잡힌 문자열 u와 v로 분리하기
        return stepone(p);
    }
    public static String stepone(String p){
        String u="";
        String v="";
        // 1단계 : 빈 문자열인 경우 빈 문자열 반환
        if(p.length()==0)return p;
        
        //if(right(p)) return p;
        
        // 2단계 : 균형 잡힌 문자열로 분리
        int l=0,r=0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='(')l+=1;
            else if(p.charAt(i)==')')r+=1;
            if(r==l){
                u=p.substring(0,i+1);
                v=p.substring(i+1,p.length());
                break;
            }
        }
      
        // 3단계 : u가 올바른 괄호 문자열이라면
        if(right(u)){
            return u+=stepone(v);
        }else{//4단계 : u 가 올바른 괄호 문자열이 아니라면
            String news="(";
            news+=stepone(v);
            news+=")";
            
            String mid = u.substring(1,u.length()-1);
            
            for(int i=0;i<mid.length();i++){
                if(mid.charAt(i)==')')news+="(";
                else news+=")";
            }
            return news;
        }
    }
        
    public static boolean right(String p){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<p.length();i++){
            char now = p.charAt(i);
            if(now=='('){
                stack.push(now);
            }else if(now==')'){
                if(stack.isEmpty())return false;
                else{
                    stack.pop();
                }
            }
        }
        
        if(stack.isEmpty())return true;
        return false;
    }
}