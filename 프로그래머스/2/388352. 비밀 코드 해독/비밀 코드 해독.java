import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        
        boolean[]visited = new boolean[n+1];
        List<Integer> list = new ArrayList<>();
        
        dfs(list,n,q,ans,visited,1);
        return answer;
    }
    public static void dfs(List<Integer> list, int n, int[][]q, int[]ans,boolean[]visited,int start){
        if(list.size()==5){
            int cnt = 0;
            boolean right = true;
            for(int i=0;i<q.length;i++){
                cnt=0;
                for(int j=0;j<5;j++){
                    if(list.contains(q[i][j]))cnt+=1;
                }
                if(cnt!=ans[i])right=false;
            }
            if(right)answer+=1;
            return;
        }
        for(int i=start;i<=n;i++){
            if(!visited[i]){
                visited[i]=true;
                list.add(i);
                dfs(list,n,q,ans,visited,i+1);
                visited[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}