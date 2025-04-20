
import java.io.*;
import java.util.*;
public class Main {
	public static int N,Line;
	public static int[][]arr;
	public static boolean[]visited;
	public static void main(String[]args) throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		Line=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1][N+1];
		visited=new boolean[N+1];
		
		for(int i=0;i<Line;i++) {
			st=new StringTokenizer(bf.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			arr[x][y]=1;
			arr[y][x]=1;
		}
		int answer=0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				answer+=1;
				visited[i]=true;
				dfs(i);
			}
		}
		System.out.println(answer);
	}
	
	public static void dfs(int x) {
		for(int i=1;i<=N;i++) {
			if(arr[x][i]==1&&!visited[i]) {
				visited[i]=true;
				dfs(i);
			}
		}
	}
}
