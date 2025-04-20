
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][]arr = new int[M][N];
		boolean[][]visited = new boolean[M][N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int []dx= {0,1};
		int []dy= {1,0};
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0,0});
		visited[0][0]=true;
		while(!queue.isEmpty()) {
			int[]now=queue.poll();
			if(now[0]==M-1&&now[1]==N-1) {
				System.out.println("Yes");
				return;
			}
			for(int i=0;i<2;i++) {
				int new_x=now[0]+dx[i];
				int new_y=now[1]+dy[i];
				
				if((new_x>=0&&new_x<M)&&(new_y>=0&&new_y<N)&&arr[new_x][new_y]==1&&!visited[new_x][new_y]) {
					queue.add(new int[] {new_x,new_y});
					visited[new_x][new_y]=true;
				}
			}
		}
		System.out.println("No");
	}
}
