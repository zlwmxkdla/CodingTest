import java.util.*;
class Solution {
    static boolean[][]visited;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int n = storage.length;
        int m = storage[0].length();
        char[][] grid = new char[n][m];
        for(int i=0;i<n;i++){
            String s = storage[i];
            for(int j=0;j<m;j++){
                grid[i][j]=s.charAt(j);
            }
        }
        
        visited = new boolean[n][m];
        
        for(int i=0;i<requests.length;i++){
            String s = requests[i];
            if(s.length()==1){
                //지게차 사용 - 적어도 1면이 외부와 연결
                boolean[][]temp = new boolean[n][m];
                for(int k=0;k<n;k++){
                    for(int j=0;j<m;j++){
                        temp[k][j]=visited[k][j];
                    }
                }
                for(int k=0;k<n;k++){
                    for(int j=0;j<m;j++){
                        if(grid[k][j]==s.charAt(0))removeifcan(k,j,n,m,temp);
                    }
                }
               
            }else{
                //크레인 사용
                char c = s.charAt(0);
                for(int k=0;k<n;k++){
                    for(int j=0;j<m;j++){
                        if(grid[k][j]==c)visited[k][j]=true;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j])answer+=1;
            }
        }
        return answer;
    }
    public static void removeifcan(int x, int y,int n, int m,boolean[][]temp){
        int[] dx = {0,-1,1,0};
        int[] dy = {1,0,0,-1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        boolean[][]v = new boolean[n][m];
        v[x][y]=true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                
                
                if((nx<0||nx>=n)||(ny<0||ny>=m)){
                    visited[x][y]=true;
                    return;
                }
             
                if(!v[nx][ny]&&temp[nx][ny]){
                    v[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }
            }
            
            
        }
    }
    
}