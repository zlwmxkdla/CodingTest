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
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        boolean[] nums = new boolean[n+1];
        
        List<List<node>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++)graph.add(new ArrayList<>());
        for(int i=0;i<fares.length;i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            graph.get(from).add(new node(to,cost));
            graph.get(to).add(new node(from,cost));
        }
        List<Integer>[]dist = new List[3];
        dist[0]=dijkstra(s,n,s,a,b,fares,graph);
        answer=Integer.MAX_VALUE;
        dist[1]=dijkstra(a,n,s,a,b,fares,graph);
        answer=Integer.MAX_VALUE;
        dist[2]=dijkstra(b,n,s,a,b,fares,graph);
        
        int min_dist=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int sum=0;
            for(int j=0;j<3;j++){
                sum+=dist[j].get(i);
            }
            min_dist=Math.min(min_dist,sum);
        }
        
        return min_dist;
    }
    public static List<Integer> dijkstra(int start, int n,int s, int a, int b, int[][]fares,List<List<node>> graph){
        int[] cost = new int[n+1];
        boolean[]visited = new boolean[n+1];
        for(int i=0;i<=n;i++)cost[i]=Integer.MAX_VALUE;
        cost[start]=0;
        PriorityQueue<node> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.cost));
        pq.add(new node(start,0));
        int answer = 0;
        
        
        while(!pq.isEmpty()){
            node now = pq.poll();
            if(visited[now.to])continue;
            visited[now.to]=true;
            
            
            for(node e:graph.get(now.to)){
                int weight = Math.min(cost[e.to], cost[now.to]+e.cost);
                cost[e.to]=weight;
                pq.add(new node(e.to,weight));
            }
        }
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<cost.length;i++)l.add(cost[i]);
        return l;
    }
}