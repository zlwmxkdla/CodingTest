import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] dx = {0,1,-1,0}; int[]dy={1,0,0,-1};
        int n = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][]eggs = new int[n][n];

        // 입력받기
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                eggs[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;//계란의 이동이 일어나는 횟수
        boolean canChange = true;
        while(canChange){//계란의 이동이 가능한 경우 
            canChange = false;
            boolean[][] visited = new boolean[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!visited[i][j]){
                        //아직 방문하지 않은 경우 
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[]{i,j});
                        //visited[i][j]=true;

                        //합쳐질 계란틀들 저장
                        List<int[]> merged = new ArrayList<>();
                        merged.add(new int[]{i,j});
                        //합쳐진 계란의 총합
                        int sum = eggs[i][j];
                        while(!q.isEmpty()){
                            int[]now = q.poll();
                            for(int k=0;k<4;k++){
                                int nx = now[0]+dx[k];
                                int ny = now[1]+dy[k];
                                if(nx>=0&&nx<n&&ny>=0&&ny<n){
                                    int gap = Math.abs(eggs[now[0]][now[1]]-eggs[nx][ny]);
                                    if(!visited[nx][ny]&&(gap>=L&&gap<=R)){
                                        visited[i][j]=true;
                                        sum+=eggs[nx][ny];//합쳐진 계란의 총합 갱신
                                        visited[nx][ny]=true;
                                        merged.add(new int[]{nx,ny});//합쳐질 계란 리스트에 추가
                                        q.add(new int[]{nx,ny});
                                    }
                                }
                                
                            }
                        }
                        
                        if(merged.size()>1){
                            //합쳐질 칸이 존재한다면
                            canChange=true;
                            //분리될 양
                            int splited = sum/merged.size();
                            //다시 분리하기
                            for(int[] element:merged){
                                int x = element[0];
                                int y = element[1];
                                eggs[x][y]=splited;
                            }
                        }
                    }
                }
            }
            if(canChange)count+=1;
        
        }

        System.out.println(count);
    }
}