
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[]args) throws IOException{
		BufferedReader  bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<test;i++) {
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][]dp = new int[M+1][M+1];
			for(int j=0;j<=M;j++) {
				dp[j][0]=1;
				dp[j][1]=j;
				dp[j][j]=1;
			}
			for(int j=2;j<=M;j++) {
				for(int k=1;k<=j;k++) {
					dp[j][k]=dp[j-1][k]+dp[j-1][k-1];
				}
			}
			sb.append(dp[M][N]+"\n");
		}
		System.out.println(sb.toString());

	}
}
