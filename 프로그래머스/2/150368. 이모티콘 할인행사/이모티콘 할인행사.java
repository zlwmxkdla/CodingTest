import java.util.*;
class Solution {
    static List<int[]> anslist = new ArrayList<>();
    static int[] discount = {10,20,30,40};
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        
        Set<String> List = new HashSet<>();

        dfs("",List,emoticons.length);
        
        for(String s : List){
            caculate(s,users,emoticons);
        }
        Collections.sort(anslist,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[]b){
                if(a[0]!=b[0])return b[0]-a[0];
                return b[1]-a[1];
            }
        });
           
        answer = new int[]{anslist.get(0)[0],anslist.get(0)[1]};
        return answer;
    }
    public static void caculate(String s, int[][]users,int[]emoticons){
        int service = 0;//서비스 가입 사용자 수
        int purchasecost = 0;//이모티콘 구매 비용
        String[] ss = s.split(" ");
        //System.out.println(ss[0]+" "+ss[1]);
        for(int i=0;i<users.length;i++){
            int nowpdiscount = users[i][0];//현재 사용자의 할인율
            int nowpcost = users[i][1];//서비스 가입 충족하는 최소 금액
            int cost = 0;//이모티콘 구입 비용
            for(int j=0;j<ss.length;j++){
                int ratio = Integer.parseInt(ss[j]);
                //System.out.println(ratio);
                if(nowpdiscount<=ratio){
                    cost += (emoticons[j]*(100-ratio)/100);
                    //System.out.println(cost);
                }
            }
            //System.out.println("현재 사용자 : " + i +"인덱스 사람의 할인율 :"+nowpdiscount+" , 최소 금액 :"+nowpcost);
            //System.out.println("현재 사용자 : " + i +"인덱스 사람, 비용 :"+cost);
            if(cost>=nowpcost)service+=1;
            else purchasecost+=cost;
        }
        //System.out.println(service+" "+purchasecost);
        anslist.add(new int[]{service,purchasecost});
    }
    
    public static void dfs(String s,Set<String>List,int n){
        if(s.length()==n*3){
            List.add(s);
            return;
        }
        for(int i=0;i<4;i++){
            s+=String.valueOf(discount[i]);
            s+=" ";
            dfs(s,List,n);
            if(s.length()==3)s="";
            else s = s.substring(0,s.length()-3);

        }
    }
}