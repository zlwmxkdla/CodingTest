import java.util.*;
class Solution {
    static int[]dx = {0,-1,1,0};
    static int[]dy = {1,0,0,-1};
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        int sx=0,sy=0,ex=0,ey=0,lx=0,ly=0;
        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maps[i].charAt(j)=='S'){
                    //시작점
                    sx=i;
                    sy=j;
                    map[i][j]=0;
                }else if(maps[i].charAt(j)=='E'){
                    //출구
                    ex=i;
                    ey=j;
                    map[ex][ey]=0;
                }else if(maps[i].charAt(j)=='L'){
                    lx=i;
                    ly=j;
                    map[lx][ly]=0;
                }else if(maps[i].charAt(j)=='O'){
                    map[i][j]=0;
                }else{
                    map[i][j]=1;
                }
            }
        }
        
        // 1. 레버 위치로 이동
        
        boolean[][]visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx,sy,0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0]==lx&&now[1]==ly){
                answer=now[2];
                break;
            }
            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+ dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    if(!visited[nx][ny]&&map[nx][ny]==0){
                        visited[nx][ny]=true;
                        q.add(new int[]{nx,ny,now[2]+1});
                    }
                }
            }
        }
        if(answer==0)return -1;
        int temp = answer;
        // 2. 출구로 이동
        visited= new boolean[n][m];
        q = new LinkedList<>();
        q.add(new int[]{lx,ly,0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0]==ex&&now[1]==ey){
                answer+=now[2];
                break;
            }
            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+ dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    if(!visited[nx][ny]&&map[nx][ny]==0){
                        visited[nx][ny]=true;
                        q.add(new int[]{nx,ny,now[2]+1});
                    }
                }
            }
        }
        
        if(answer==temp)return -1;
        
        return answer;
    }
}