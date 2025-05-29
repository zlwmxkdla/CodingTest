import java.util.*;
class Solution {
    static boolean[]visited;

    static List<List<Integer>> list;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        list = new LinkedList<>();
        for(int i=0;i<=n;i++)list.add(new LinkedList<>());
        for(int i=0;i<wires.length;i++){
            int from = wires[i][0];
            int to = wires[i][1];
            list.get(from).add(to);
            list.get(to).add(from);
        }
        
        for(int i=0;i<wires.length;i++){
            int rx = wires[i][0];
            int ry = wires[i][1];
            list.get(rx).remove(Integer.valueOf(ry));
            list.get(ry).remove(Integer.valueOf(rx));//연결 관계 끊기
            visited = new boolean[n+1];
            for(int j=1;j<=n;j++){
                if(!visited[j]){
                    visited[j]=true;
                    dfs(j,0);
                    break;
                }
            }
            int depth = 0;
            for(int j=1;j<=n;j++)if(!visited[j])depth+=1;
            int rest = n-depth;
            answer = Math.min(answer,Math.abs(depth-rest));
        
            list.get(rx).add(ry);//다시 끊었던 관계 연결하기
            list.get(ry).add(rx);
        }
        return answer;
    }
    public static void dfs(int now, int depth){
        for(Integer e:list.get(now)){
            if(!visited[e]){
                visited[e]=true;
                dfs(e,depth+1);
            }
        }
    }
}