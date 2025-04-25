import java.util.*;
class Solution {
    static int[] depth;
    static boolean[]visited;
    static List<Integer>[] list;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        depth = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i=0;i<=n;i++)list[i]=new ArrayList<>();
        for(int i=0;i<edge.length;i++){//그래프 형태 저장
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(Integer e: list[now]){
                if(!visited[e]){
                    visited[e]=true;
                    depth[e]=depth[now]+1;
                    q.add(e);
                }
            }
        }
        
        Arrays.sort(depth);
        int max_depth = depth[n];
        for(int i=n;i>0;i--){
            if(depth[i]!=max_depth){
                answer = n - i;
                break;
            }
        }
        return answer;
    }
   
}