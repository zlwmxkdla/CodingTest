import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();//키 : 아이디, 값 : 이름 
        List<String[]> list = new ArrayList<>();// {아이디, 유형(입장,퇴장)}
        
        for(int i=0;i<record.length;i++){
            String[] words = record[i].split(" ");
            if(words[0].equals("Leave")){
                list.add(new String[]{words[1],words[0]});
                continue;
            }
            map.put(words[1],words[2]);
            if(words[0].equals("Change"))continue;
            list.add(new String[]{words[1],words[0]});
        }
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            String[] now = list.get(i);
            if(now[1].equals("Enter")){
                answer[i] = new String(map.get(now[0])+"님이 들어왔습니다.");        
            }else if(now[1].equals("Leave")){
                answer[i]= new String(map.get(now[0])+"님이 나갔습니다.");
            }
        }
        return answer;
    }
}