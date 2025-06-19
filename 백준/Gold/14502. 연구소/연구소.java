
import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {0,1,-1,0}; static int[] dy={1,0,0,-1};
    static int N; static int M;
    static int[][]board;
    static List<int[]>viruses;
    public static void main(String[]args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int answer = Integer.MIN_VALUE;
        viruses = new ArrayList<>();
        board = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==2){
                    viruses.add(new int[]{i,j});//바이러스의 위치 저장
                }
            }
        }

        //벽 세우기
        for (int i = 0; i < N * M; i++) {
            for (int j = i + 1; j < N * M; j++) {
                for (int k = j + 1; k < N * M; k++) {
                    int x1 = i / M, y1 = i % M;
                    int x2 = j / M, y2 = j % M;
                    int x3 = k / M, y3 = k % M;

                    if (board[x1][y1] != 0 || board[x2][y2] != 0 || board[x3][y3] != 0) continue;

                    // board 복사본 만들기
                    int[][] temp = copyBoard(board);
                    temp[x1][y1] = 1;
                    temp[x2][y2] = 1;
                    temp[x3][y3] = 1;

                    spread(temp);
                    answer = Math.max(answer, safe_guard(temp));
                }
            }
        }

        System.out.println(answer);
        
    }

    public static int[][] copyBoard(int[][] original) {//원본 배열의 깊은 복사를 위한 배열 
        int[][] newBoard = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            newBoard[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return newBoard;
    }


    public static void spread(int[][]tempBoard){
        //바이러스 확산시키기
        boolean[][]visited = new boolean[N][M];
        
        for(int[] e:viruses){
            Queue<int[]> q = new LinkedList<>();
            q.add(e);
            while(!q.isEmpty()){
                int[] now = q.poll();
                for(int i=0;i<4;i++){
                    int nx = now[0]+dx[i];
                    int ny = now[1]+dy[i];
                    if(nx>=0&&nx<N&&ny>=0&&ny<M){
                        if(!visited[nx][ny]&&tempBoard[nx][ny]==0){
                            q.add(new int[]{nx,ny});
                            visited[nx][ny]=true;
                            tempBoard[nx][ny]=2;//바이러스로 교체하기
                        }
                    }
                }
            }
        }

    }
    public static int safe_guard(int[][]tempBoard){
        boolean[][]visited = new boolean[N][M];
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tempBoard[i][j]==0&&!visited[i][j]){
                    visited[i][j]=true;

                    q.add(new int[]{i,j});
                    count+=1;
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        for(int k=0;k<4;k++){
                            int nx = now[0]+dx[k];
                            int ny = now[1]+dy[k];
                            if(nx>=0&&nx<N&&ny>=0&&ny<M){
                                if(tempBoard[nx][ny]==0&&!visited[nx][ny]){
                                    visited[nx][ny]=true;
                                    q.add(new int[]{nx,ny});
                                    count+=1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}
