package 탐색;
import java.io.*;
import java.util.*;

public class Backjune2583영역구하기 {
	static int[][]arr;
	static boolean visited[][];
	static int answer=0;
	static int m;
	static int n;
	static int[]dx= {-1,0,0,1};
	static int[]dy= {0,1,-1,0};
	static int area;
	static ArrayList<Integer> areas=new ArrayList<>();
	
	public static void dfs(int i, int j) {
		visited[i][j]=true;
		area+=1;
		arr[i][j]=1;
		for(int s=0;s<4;s++) {
			int new_x=i+dx[s];
			int new_y=j+dy[s];
			
			if(new_x>=m||new_x<0||new_y<0||new_y>=n)continue;
			
			if(!visited[new_x][new_y]&&arr[new_x][new_y]==0) {
				
				dfs(new_x,new_y);
			}
		}
	}
	
	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		int boxes=Integer.parseInt(st.nextToken());
		
		arr=new int[m][n];
		visited=new boolean[m][n];
		for(int i=0;i<boxes;i++) {
			st=new StringTokenizer(bf.readLine());
			 int x_left=Integer.parseInt(st.nextToken());
	         int y_left=Integer.parseInt(st.nextToken());
	         int x_right=Integer.parseInt(st.nextToken());
	         int y_right=Integer.parseInt(st.nextToken());
		
	         for(int j=m-y_right;j<=m-1-y_left;j++) {
	             for(int k=x_left;k<=x_right-1;k++) {
	                arr[j][k]=1;
	             }
	          }
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==0&&!visited[i][j]) {
					answer+=1;
					area=0;
					dfs(i,j);
					areas.add(area);
				}
			}
			
		}
		System.out.println(answer);
		int []sorted=new int[answer];
		for(int i=0;i<answer;i++)sorted[i]=areas.get(i);
		Arrays.sort(sorted);
		for(int i=0;i<answer;i++)System.out.print(sorted[i]+" ");
	}
}
