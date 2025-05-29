import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[]dx={-1,0,0,1};int[]dy={0,1,-1,0};
        int m = maps.length;
        int n = maps[0].length;
        
        boolean[][]visited = new boolean[m][n];
        Queue<int[]>q=new LinkedList<>();
        
        q.add(new int[]{0,0,1});
        while(!q.isEmpty()){
            int[]now=q.poll();
            if(now[0]==m-1&&now[1]==n-1)return now[2];
            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(nx>=0&&nx<m&&ny>=0&&ny<n){
                    if(!visited[nx][ny]&&maps[nx][ny]==1){
                        visited[nx][ny]=true;
                        q.add(new int[]{nx,ny,now[2]+1});
                    }
                }
            }
        }
        return -1;
    }
}