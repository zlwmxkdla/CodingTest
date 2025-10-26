import java.util.*;
class Solution {
    static int answer= 0;
    public int solution(int n) {
        
        int [][]grid = new int[n][n];
        dfs(grid, 0, n);
        return answer;
    }
    public static void dfs(int[][]grid, int line, int n){
        if(line>=n){
            answer+=1;
            return;
        }
        for(int i=0;i<n;i++){
            if(grid[line][i]==0&&can(grid,line,i,n)){
                grid[line][i]=1;
                dfs(grid,line+1,n);
                grid[line][i]=0;
            }
        }
    }
    public static boolean can(int[][] grid, int line, int col,int n){
        int[]dx = {0,1,-1,0,1,-1,-1,1};
        int[]dy = {1,0,0,-1,1,1,-1,-1};
        int x = line;
        int y = col;
        for(int i=0;i<8;i++){
            while(true){
                
            
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<n){
                    if(grid[nx][ny]==1)return false;
                    x = nx;
                    y = ny;
                }else break;
            }
            x = line;
            y = col;
        }
        return true;
    }
}