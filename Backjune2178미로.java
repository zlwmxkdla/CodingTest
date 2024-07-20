package 그래프;
import java.io.*;
import java.util.*;

public class Backjune2178미로 {
	static int arr[][];
	static boolean visited[][];
	
	static int[]dx= {-1,0,0,1};
	static int[]dy= {0,-1,1,0};
		
	
	public static void main(String[]args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		arr=new int[n+1][m+1];
		visited=new boolean[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			String temp=bf.readLine();
			for(int j=1;j<=m;j++) {
				arr[i][j]=temp.charAt(j-1)-'0';
			}
		}
		
		visited[1][1]=true;
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[]{1,1,1});
		
		
		while(!q.isEmpty()) {
			
			int[] temp=q.poll();
			int x=temp[0];
			int y=temp[1];
			int dist=temp[2];
			
			if(x==n&&y==m) {
				System.out.println(dist);
				return;
			}
			for(int i=0;i<4;i++) {				
				int new_x=x+dx[i];
				int new_y=y+dy[i];
				
				if(new_x<1||new_x>n||new_y<1||new_y>m)continue;
				if(arr[new_x][new_y]==1&&!visited[new_x][new_y]) {
					
					visited[new_x][new_y]=true;
					q.add(new int[]{new_x,new_y,dist+1});
				}
			}
		}
		
	}
}
