import java.util.*;
class Solution {
    static Set<String> ans;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        List<List<String>> list = new ArrayList<>();
        for(int i=0;i<banned_id.length;i++){
            list.add(new ArrayList<>());
            String ban_id = banned_id[i];
            
            for(int j=0;j<user_id.length;j++){
                boolean same = true;
                if(user_id[j].length()!=ban_id.length())continue;
                for(int k=0;k<ban_id.length();k++){
                    if(ban_id.charAt(k)=='*')continue;
                    if(ban_id.charAt(k)!=user_id[j].charAt(k)){
                        same=false;
                        break;
                    }
                }
                if(same)list.get(i).add(user_id[j]);
            }
            
        }
        
        Set<String> set = new HashSet<>();
        ans = new HashSet<>();
        dfs(set,list,user_id,0,banned_id.length);
        return ans.size();
    }
    public static void dfs(Set<String> set, List<List<String>> list, String[] user_id,int index,int n){
        if(set.size()==n){
            String aa = "";
            List<String> ll = new ArrayList<>();
            for(String s : set)ll.add(s);
            Collections.sort(ll);
            for(String s : ll)aa+=(s+" ");
            ans.add(aa);
            return;
        }
        for(int i=0;i<list.get(index).size();i++){
            String ss = list.get(index).get(i);
            if(set.contains(ss))continue;
            set.add(ss);
            dfs(set,list,user_id,index+1,n);
            set.remove(ss);
        }
    }
}