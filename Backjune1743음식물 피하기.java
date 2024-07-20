package 탐색;
import java.io.*;
import java.util.*;

public class Backjune1743음식물피하기 {
	static int n,m;
	static int arr[][];
	static boolean visited[][];
	static int garbage;
	static int count;
	static int []dx= {-1,0,0,1};
	static int []dy= {0,-1,1,0};
	
	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		garbage=Integer.parseInt(st.nextToken());
		
		arr=new int[n+1][m+1];
		visited=new boolean[n+1][m+1];
		
		ArrayList<Integer> size=new ArrayList<>();
		
		for(int i=0;i<garbage;i++) {
			st=new StringTokenizer(bf.readLine());
			int s=Integer.parseInt(st.nextToken());
			int t=Integer.parseInt(st.nextToken());
			arr[s][t]=1;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					count=1;
					dfs(i,j);
					size.add(count);
				}
			}
		}
		int max=0;
		for(int i=0;i<size.size();i++) {
			if(size.get(i)>max)max=size.get(i);
		}
		System.out.print(max);
	}
	
	public static void dfs(int i,int j) {
		visited[i][j]=true;
		for(int k=0;k<4;k++) {
			int new_x=i+dx[k];
			int new_y=j+dy[k];
			if(new_x<1||new_x>n||new_y<1||new_y>m)continue;
			if(arr[new_x][new_y]==1&&!visited[new_x][new_y]) {
				count+=1;
				dfs(new_x,new_y);	
			}
		}
	}
}
