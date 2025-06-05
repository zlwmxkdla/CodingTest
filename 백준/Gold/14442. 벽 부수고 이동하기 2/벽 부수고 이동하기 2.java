import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[]args)throws IOException{
        int n; int m; int k;
        int[]dx = {0,1,-1,0}; int[]dy={1,0,0,-1};
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][]arr = new int[n+1][m+1];
        boolean[][][]visited = new boolean[n+1][m+1][k+1];
        //visited[x][y][0] : (x,y)를 벽을 부수지 않고 방문한 경우
        //visited[x][y][1] : (x,y)를 벽을 부수고 방문한 경우 
        for(int i=0;i<n;i++){
            String line = bf.readLine();
            for(int j=0;j<m;j++){
                arr[i+1][j+1]=line.charAt(j)-'0';
            }
        }

        //0은 이동할 수 있는 칸 1은 이동할 수 없는 칸 
        //벽을 부수고 이동할 수 있으면 벽을 부수고 이동하는 것이 딱 한 번까지만 가능함 
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,1,1,0});//x, y, 지난 경로의 개수, 칸을 부쉈는지의 여부(0은 아직 부수지 않음)
        visited[1][1][0]=true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0]; int y = now[1]; int cnt = now[2]; int broke = now[3];
            if(x==n&&y==m){
                System.out.println(cnt);
                return;
            }
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>0&&nx<=n&&ny>0&&ny<=m){
                    if(!visited[nx][ny][broke]&&arr[nx][ny]==0){//벽이 아니고 방문할 수 있는 곳인 경우
                        visited[nx][ny][broke]=true;
                        q.add(new int[]{nx,ny,cnt+1,broke});
                    }
                    if(broke<k&&arr[nx][ny]==1&&!visited[nx][ny][broke]){//벽이지만 부술 수 있다면
                        //아직 벽을 부순 적이 없고 현재 벽을 만났을 경우 
                        visited[nx][ny][broke]=true;
                        q.add(new int[]{nx,ny,cnt+1,broke+1});
                    }
                }
                
            }
            
        }
        System.out.println(-1);
    }
}
