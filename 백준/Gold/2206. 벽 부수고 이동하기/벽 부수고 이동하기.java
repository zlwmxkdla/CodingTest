
import java.util.*;
import java.io.*;
public class Main {
	static int N,M;
    static int [][]arr;
    static int []dx = {-1,0,0,1};
    static int []dy = {0,1,-1,0};
    static boolean [][][]visited;
    static class Node{
    	int x, y, breakwall, dist;
    	Node(int x, int y, int breakwall, int dist){
    		this.x = x;
    		this.y = y; 
    		this.breakwall = breakwall;
    		this.dist = dist;
    	}
    }
    public static void main(String[]args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M][2];
        
        for(int i=0;i<N;i++) {
            String line = bf.readLine();
            for(int j=0;j<M;j++) {
                arr[i][j]=line.charAt(j)-'0';
            }
        }

        int result = bfs();
        
        System.out.println(result);
    }
    static int bfs() {
    	Queue<Node> q = new LinkedList<>();
    	q.add(new Node(0,0,0,1));
    	visited[0][0][0]=true;//벽을 부쉈는가와 안 부쉈는가의 두 가지 상태가 존재
    	
    	while(!q.isEmpty()) {
    		Node now = q.poll();
    		if(now.x==N-1&&now.y==M-1)return now.dist;
    		
    		for(int i=0;i<4;i++) {
    			int nx = now.x+dx[i];
    			int ny = now.y+dy[i];
    			
    			if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 이동 가능 && 아직 벽을 안 부쉈고 벽이라면
                    if(arr[nx][ny] == 1 && now.breakwall == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.add(new Node(nx, ny, 1, now.dist + 1));
                    }
                    // 이동 가능 && 벽이 아니고 방문 안했으면
                    else if(arr[nx][ny] == 0 && !visited[nx][ny][now.breakwall]) {
                        visited[nx][ny][now.breakwall] = true;
                        q.add(new Node(nx, ny, now.breakwall, now.dist + 1));
                    }
                }

    		}
    	}
    	return -1;
    }
}
