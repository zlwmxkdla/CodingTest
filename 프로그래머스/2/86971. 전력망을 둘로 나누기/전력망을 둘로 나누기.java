import java.util.*;
class Solution {
    static int cnt;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        for(int i=0;i<wires.length;i++){
            boolean[]disconnect = new boolean[wires.length];
            disconnect[i]=true;
            answer = Math.min(answer,caculate(disconnect,n,wires));
        }
        return answer;
    }
    public static int caculate(boolean[]disconnect,int n,int[][]wires){
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++)list.add(new ArrayList<>());
        for(int i=0;i<wires.length;i++){
            if(!disconnect[i]){
                int from = wires[i][0];
                int to = wires[i][1];
                list.get(from).add(to);
                list.get(to).add(from);
            }
        }
        boolean[]visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=true;
        int cnt =1;
        while(!q.isEmpty()){
            int now = q.poll();
            for(Integer e:list.get(now)){
                if(!visited[e]){
                    visited[e]=true;
                    q.add(e);
                    cnt+=1;
                }
            }
        }
        int remain = n-cnt;
        return Math.abs(cnt-(n-cnt));
    }
    
}