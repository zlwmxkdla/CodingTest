class Solution {
    static int answer = Integer.MIN_VALUE;
    public int solution(int[] info, int[][] edges) {
        dfs(0, new boolean[info.length],0,0,info,edges);
        return answer;
    }
    public static void dfs(int now,boolean[]visited,int sheep,int wolf,int[]info,int[][]edges){
        visited[now]=true;
        if(info[now]==0){
            //양인 경우
            sheep+=1;
            answer = Math.max(answer,sheep);
        }else{
            wolf+=1;
        }
        
        if(wolf>=sheep)return; //늑대의 수가 더 많다면 백트래킹
        for(int[]edge:edges){
            if(visited[edge[0]]&&!visited[edge[1]]){
                boolean[] copy = visited.clone();
                dfs(edge[1],copy,sheep,wolf,info,edges);
            }
        }
    }
}