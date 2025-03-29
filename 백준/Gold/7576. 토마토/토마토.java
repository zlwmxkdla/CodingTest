
import java.io.*;
import java.util.*;
public class Main {
	public static int M,N;
	public static int [][]arr;
	public static Queue<tomato> queue=new LinkedList<>();
	public static int dx[]= {-1,0,0,1};
	public static int dy[]= {0,-1,1,0};
	
	public static class tomato{
		int x;
		int y;
		int day;
		public tomato(int x,int y,int day) {
			this.x=x;
			this.y=y;
			this.day=day;
		}
	}
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1)queue.add(new tomato(i,j,0));
			}
		}
		int day=0;
		while(!queue.isEmpty()) {
			tomato temp=queue.poll();
			int cx=temp.x;
			int cy=temp.y;
			day=temp.day;
			for(int k=0;k<4;k++) {
				int nx=cx+dx[k];
				int ny=cy+dy[k];
				if(nx>=0&&nx<N&&ny>=0&&ny<M) {
					if(arr[nx][ny]==0) {
						arr[nx][ny]=1;
						queue.add(new tomato(nx,ny,day+1));
					}
					
				}
			}
		}
		if(checkTomato()) {
			System.out.println(day);
		}else {
			System.out.println(-1);
		}
	
	}
	public static boolean checkTomato() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0)return false;
			}
		}
		return true;
	}
}
