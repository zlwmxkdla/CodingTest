import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][]dp = new int[N+1][N+1];
		for(int i=0;i<=N;i++) {
			dp[i][1]=i;
			dp[i][0]=1;
			dp[i][i]=1;
		}
		
		for(int i=2;i<=N;i++) {
			for(int j=1;j<i;j++) {
				dp[i][j]=dp[i-1][j-1]%10007+dp[i-1][j]%10007;
			}
		}
		System.out.println(dp[N][K]%10007);
		sc.close();
	}
}
