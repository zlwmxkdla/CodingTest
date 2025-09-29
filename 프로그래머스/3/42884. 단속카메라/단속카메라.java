import java.util.*;
class Solution {
    public static class node{
        int from;
        int to;
        public node(int from, int to){
            this.from=from;
            this.to=to;
        }
    }
    public int solution(int[][] routes) {
        int answer = 0;
        node[] list = new node[routes.length];
        for(int i=0;i<routes.length;i++){
            list[i]=new node(routes[i][0],routes[i][1]);
        }
        Arrays.sort(list,new Comparator<node>(){
            @Override
            public int compare(node a, node b){
                int r = a.from-b.from;
                if(r!=0)return r;
                return a.to-b.to;
            }
        });
        
            
        int f = list[0].from;
        int t = list[0].to;
        for(int i=1;i<list.length;i++){
            if(list[i].from>=f&&list[i].from<=t){
                int[] arr = new int[4];
                arr[0]=f;
                arr[1]=t;
                arr[2]=list[i].from;
                arr[3]=list[i].to;
                Arrays.sort(arr);
                f=arr[1];
                t=arr[2];
            }else{
                answer+=1;
                f=list[i].from;
                t=list[i].to;
            }
        }
        return answer+1;
    }
}