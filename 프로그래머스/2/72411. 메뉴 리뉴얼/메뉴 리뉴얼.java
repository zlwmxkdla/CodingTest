import java.util.*;
class Solution {
    public static List<String> list=new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        for(int i=0;i<orders.length;i++){
            String temp = orders[i];
            char[] ss = temp.toCharArray();
            Arrays.sort(ss);
            String ans ="";
            for(int j=0;j<ss.length;j++)ans+=ss[j];
            orders[i]=ans;
        }
        for(int i=0;i<course.length;i++){
            int len = course[i];
            find(len,orders);
        }
        String[]answer = list.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
    public static void find(int len, String[]orders){
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<orders.length;i++){
            String s = orders[i];
            boolean[]visited = new boolean[s.length()];
            if(s.length()<len)continue;
            dfs(0,"",len,map,visited,s);
        }
        int max= 0;
        
        for(Map.Entry<String,Integer> e:map.entrySet()){
            int cnt = e.getValue();
            if(cnt>=2){
                if(cnt>max){
                    max=cnt;
                }
            }
                
        }
        for(Map.Entry<String,Integer> e:map.entrySet()){
            int cnt = e.getValue();
            if(cnt==max){
                list.add(e.getKey());
            }
                
        }
        
    }
    public static void dfs(int start,String s,int len,Map<String,Integer> map,boolean[]visited,String order){
        if(s.length()==len){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(int i=start;i<visited.length;i++){
            if(!visited[i]){
                visited[i]=true;
                s+=String.valueOf(order.charAt(i));
                dfs(i+1,s,len,map,visited,order);
                s=s.substring(0,s.length()-1);
                visited[i]=false;
            }
            
        }
    }
}