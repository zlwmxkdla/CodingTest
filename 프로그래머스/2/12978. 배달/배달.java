import java.util.*;
class Solution {
    public static class node{
        int to;
        int cost;
        public node(int to, int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<List<node>> list = new ArrayList<>();
        for(int i=0;i<=N;i++)list.add(new ArrayList<>());
        for(int i=0;i<road.length;i++){
            int from=road[i][0];
            int to = road[i][1];
            int cost = road[i][2];
            list.get(from).add(new node(to,cost));
            list.get(to).add(new node(from,cost));
        }
        
        boolean[]visited = new boolean[N+1];
        int[]costs = new int[N+1];
        for(int i=1;i<=N;i++)costs[i]=Integer.MAX_VALUE;
        PriorityQueue<node> q = new PriorityQueue<>((a,b)->a.cost-b.cost);
        q.add(new node(1,0));
        
        while(!q.isEmpty()){
            node now = q.poll();
            if(visited[now.to])continue;
            visited[now.to]=true;
            for(node n:list.get(now.to)){        
                if(!visited[n.to]){
                    costs[n.to]=Math.min(now.cost+n.cost,costs[n.to]);
                    q.add(new node(n.to,costs[n.to])); 
                }
                
                
            }
        }
        
        Arrays.sort(costs);
        
        for(int i=0;i<costs.length;i++){
            if(costs[i]<=K)answer+=1;
            else break;
        }
        return answer;
    }
}