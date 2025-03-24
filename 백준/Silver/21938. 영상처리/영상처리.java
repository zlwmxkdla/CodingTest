
import java.io.*;
import java.util.*;
public class Main {
	static int[][]arr;
	static int[][]new_arr;
	static int []dx= {-1,0,0,1};
	static int []dy= {0,-1,1,0};
	static int N,M;
	static boolean[][]visited;
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M*3];
		new_arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M*3;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			int value=0;
			for(int j=0;j<M*3;j++) {
				value+=arr[i][j];
				if(j%3==2) {
					if(value/3>=T)new_arr[i][j/3]=255;
					else new_arr[i][j/3]=0;
					value=0;
					
				}
				
			}
		}
		int answer = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j]&&new_arr[i][j]==255) {
					answer+=1;
					dfs(i,j);
				}
			}
		}
		System.out.println(answer);
	}
	public static void dfs(int x,int y) {
		visited[x][y]=true;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||nx>=N||ny<0||ny>=M)continue;
			if(!visited[nx][ny]&&new_arr[nx][ny]==255) {
				visited[nx][ny]=true;
				dfs(nx,ny);
			}
		}
	}
}
