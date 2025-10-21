import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;//세로
        int m = land[0].length;//가로
        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};
        int[] ans = new int[m+1];
        
        boolean[][]visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1&&!visited[i][j]){
                    Set<Integer> cols = new HashSet<>();
                    cols.add(j);
                    int cnt = 1;
                    Queue<int[]> q = new LinkedList<>();
                    visited[i][j]=true;
                    q.add(new int[]{i,j});
                    
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        int sx = now[0];
                        int sy = now[1];
                        
                        for(int k=0;k<4;k++){
                            int nx = sx + dx[k];
                            int ny = sy + dy[k];
                            if(nx>=0&&nx<n&&ny>=0&&ny<m){
                                if(!visited[nx][ny]&&land[nx][ny]==1){
                                    visited[nx][ny]=true;
                                    cnt+=1;
                                    q.add(new int[]{nx,ny});
                                    cols.add(ny);
                                }
                            }
                        }
                    }
                    for(Integer e:cols)ans[e+1]+=cnt;
                }
            }
        }
        Arrays.sort(ans);
        answer = ans[m];
        return answer;
    }
}