import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1단계 : 모든 대문자를 소문자로 치환하기
        answer = new_id.toLowerCase();
       
         //2단계 : 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거하기
        answer = answer.replaceAll("[^a-z0-9._-]","");
     
         //3단계 : '...'와 '..'가 '.'로 바뀜
        answer = answer.replaceAll("\\.{2,}", ".");
      
         //4단계 : 마침표가 처음이나 끝에 위치한다면 제거하기
        if(answer.equals("."))answer="";
        else{
            if(answer.charAt(0)=='.'&&answer.length()!=0)answer = answer.substring(1,answer.length());
            if(answer.charAt(answer.length()-1)=='.'&&answer.length()!=0)answer = answer.substring(0,answer.length()-1);
        }
        
         //5단계 : new_id가 빈 문자열이라면 new_id에 "a" 대입
        if(answer.equals(""))answer="a";
    
         //6단계 : 길이가 16자 이상이라면 첫 15개의 문자를 제외한 나머지 문자 모두 제거
        if(answer.length()>15)answer = answer.substring(0,15);
        //제거 후 마침표가 마지막에 위치하면 마침표 제거
        if(answer.equals("."))answer="";
        else{
            if(answer.charAt(answer.length()-1)=='.'&&answer.length()!=0)answer = answer.substring(0,answer.length()-1);
        }
       
         //7단계 : 길이가 2자 이하라면 new_id 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 붙임
        if(answer.length()<=2){
            char c = answer.charAt(answer.length()-1);
            while(true){
                if(answer.length()==3)break;
                answer+=c;
            }
        }
        return answer;
    }
}