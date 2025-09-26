import java.util.*;
class Solution {
    int n;
    public int solution(int[] info, int[][] edges) {
        int answer = 1;
        // 간접 리스트 -> 인접리스트
        n = info.length;
        List<Integer>[] tree = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for(int i = 0; i < info.length; i++){
            tree[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            int p = edge[0];
            int c = edge[1];
            tree[p].add(c);
        }
        visited[0] = true;
        answer = dfs(info, tree, visited, 1, 0);
        visited[0] = false;
        return answer;
    }
    // 현재 상황에서 모을 수 있는 양은 최대 몇마리?
    int dfs(int[] info, List<Integer>[] tree, boolean[] visited, int sheep, int wolf){
        if(sheep == wolf) return sheep;
        int maxSheep = sheep;
        int ret = 0;
        
        // 다음 실행되는 dfs()반환값 취합하여 max값 찾기
        for(int p = 0; p < n; p++){
            for(int c : tree[p]){
                if(visited[p] && !visited[c]){
                    visited[c] = true;
                    if(info[c] == 0){
                        ret = dfs(info, tree, visited, sheep + 1, wolf);
                    }
                    else{
                        // wolf + 1??
                        ret = dfs(info, tree, visited, sheep, wolf+1);
                    }
                    visited[c] = false;            
                    maxSheep = Math.max(maxSheep, ret);
                }
            }
        }
        return maxSheep;
    }
    
}