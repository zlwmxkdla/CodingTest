import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][]arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		long[][]dp = new long[N][N];
		dp[0][0]=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==0)continue;
				//오른쪽으로 이동 가능하다면
				if(j+arr[i][j]<N) {
					dp[i][j+arr[i][j]]+=dp[i][j];
				}
				//아래쪽으로 이동 가능하다면
				if(i+arr[i][j]<N) {
					dp[i+arr[i][j]][j]+=dp[i][j];
				}	
				
				
			}
		}
		System.out.println(dp[N-1][N-1]);
	}
}
