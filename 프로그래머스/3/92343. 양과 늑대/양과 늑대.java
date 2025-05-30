import java.util.*;
class Solution {
    public int solution(int[] info, int[][] edges) {

        boolean[]visited = new boolean[info.length];//방문 배열 저장하기
        visited[0]=true;//루트 노드는 방문 처리하기
        
        return dfs(info,edges,visited,1,0);
    }
    public int dfs(int[]info,int[][]edges,boolean[]visited,int sheep,int wolf){
        //늑대가 양보다 많으면
        if(wolf>=sheep)return sheep;
        int maxsheep = sheep;
        //모든 에지 확인하기
        for(int[] edge:edges){
            int parent = edge[0];
            int child = edge[1];
            //부모가 방문된 상태이고 자식이 아직 방문되지 않은 상태인 경우 방문하기
            if(visited[parent]&&!visited[child]){
                //다음 노드 방문 처리
                visited[child]=true;
                //다음 노드가 양이라면
                if(info[child]==0){
                    maxsheep = Math.max(maxsheep,dfs(info,edges,visited,sheep+1,wolf));
                }else{
                    //다음 노드가 늑대라면
                    maxsheep = Math.max(maxsheep,dfs(info,edges,visited,sheep,wolf+1));
                }
                //다음 노드를 방문 표시 해제한다
                visited[child]=false;
            }
        }
        return maxsheep;
    }
}