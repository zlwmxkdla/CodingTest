import java.io.*;
import java.util.*;
public class Main {
    static int n,m,h,min=4;
    static int[][]arr;
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());//사람의 수
        m = Integer.parseInt(st.nextToken());//이미 유실된 선들
        h = Integer.parseInt(st.nextToken());//세로 선의 수

        arr = new int[h+2][n+2];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int weak = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            arr[weak][start]=1;//arr[weak][start]과 arr[weak][start+1]이 연결되어 있음
        }

        //정답이 3보다 크면 안 됨 
        // 세울 수 있는 다리의 개수가 1개, 2개, 3개인 경우에 대하여 
        for(int i=1;i<=3;i++){
            dfs(0,i,1); 
        }
        System.out.println(-1);
    }
    public static void dfs(int level, int num, int col){
        if(level>num||level>min){
            return;//현재의 dfs에서 세울 수 있는 다리의 개수를 넘어가거나 최솟값보다 많아지면 종료
        }
        if(isPossible()){
            min = Math.min(level,min);
            System.out.println(min);
            System.exit(0);
            return;
        }
        for(int i=col;i<=h;i++){
            for(int j=1;j<=n;j++){
                if(arr[i][j]==0&&arr[i][j-1]==0&&arr[i][j+1]==0){
                    arr[i][j]=1;
                    dfs(level+1,num,i);
                    arr[i][j]=0;
                }
            }
        }
    }
    public static boolean isPossible(){
        for(int i=1; i<=n; i++) {
            int line = i;
            int col = 1;
            while(true) {
                if(col == h+1) {
                    break;
                }
                if(arr[col][line]==1) { // 오른쪽 칸에 연결 돼 있는거
                    line+=1;
                }
                else if(arr[col][line-1] ==1) {// 왼쪽 칸에 연결 돼 있는가 
                    line -=1;
                }
                col++;
            }
            
            if(line != i) { //i번째 줄이 i번째 줄로 나오지 않는 경우
                return false;
            }
        }
        return true;
    }
}