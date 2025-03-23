
import java.io.*;
import java.util.*;
public class Main {
	public static int answer=0,N;
	public static int [][]arr;
	public static boolean []visited;
	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(bf.readLine());
		int couples=Integer.parseInt(st.nextToken());
		arr=new int[N+1][N+1];
		visited=new boolean[N+1];
		
		for(int i=0;i<couples;i++) {
			st=new StringTokenizer(bf.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			arr[x][y]=1;
			arr[y][x]=1;
		}
		
		dfs(1);
		System.out.print(answer);
	}
	
	public static void dfs(int k) {
		//현재 컴퓨터 방문처리
		visited[k]=true;
		for(int i=1;i<=N;i++) {
			if(!visited[i]&&arr[k][i]==1) {
				answer+=1;
				dfs(i);
				
			}
		}
	}
}
