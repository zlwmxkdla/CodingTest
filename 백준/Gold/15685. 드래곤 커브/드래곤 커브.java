import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        boolean edge[][]=new boolean[101][101];//꼭짓점 체그
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            //각 드래곤 커브별로 그리기
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int degree = Integer.parseInt(st.nextToken());//차수

            edge[x][y]=true;

            List<Integer> list = new ArrayList<>();
            list.add(d);
            for(int j=1;j<=degree;j++){//모든 차수까지
                for(int k=list.size()-1;k>=0;k--){
                    list.add((list.get(k)+1)%4);
                }
            }

            // 꼭짓점 체크하기
            for(Integer e:list){
                x += dx[e];
                y += dy[e];
                edge[x][y]=true;
            }

        }

        // 사각형의 개수 세기
        int answer = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(edge[i][j]&&edge[i][j+1]&&edge[i+1][j]&&edge[i+1][j+1])answer+=1;
            }
        }
        System.out.println(answer);
    }
}