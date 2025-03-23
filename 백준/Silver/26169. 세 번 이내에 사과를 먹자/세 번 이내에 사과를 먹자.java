import java.io.*;
import java.util.*;
public class Main {
	public static int []dx= {-1,0,0,1};
	public static int []dy= {0,-1,1,0};
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//그래프 정보 입력받기
		int[][]arr = new int[5][5];
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<5;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//처음 시작하는 위치 입력받기
		int stu_x,stu_y;
		st = new StringTokenizer(bf.readLine());
		stu_x=Integer.parseInt(st.nextToken());
		stu_y=Integer.parseInt(st.nextToken());
		
		if(dfs(arr,stu_x,stu_y,0,0)) {
			System.out.println(1);
		}else System.out.println(0);
	}
	public static boolean dfs(int[][]arr,int x,int y, int eat, int moves) {
		if(x<0||x>=5||y<0||y>=5||arr[x][y]==-1|moves>3)return false;
		
		//위치가 사과일 경우
		if(arr[x][y]==1)eat+=1;
		if(eat>=2)return true;
		
		int temp = arr[x][y];
		arr[x][y]=-1;
		
		boolean result = dfs(arr, x+1, y, eat, moves+1)||dfs(arr,x-1,y,eat,moves+1)||dfs(arr,x,y+1,eat,moves+1)||dfs(arr,x,y-1,eat,moves+1);
		arr[x][y]=temp;
		return result;
	}
}
