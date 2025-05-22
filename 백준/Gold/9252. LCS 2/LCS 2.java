
import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int n = a.length();
		int m = b.length();
		
		int[][]dp = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(a.charAt(i-1)==b.charAt(j-1))dp[i][j]=dp[i-1][j-1]+1;
				else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		int i=n,j=m;
		StringBuilder sb = new StringBuilder();
		while(i>0&&j>0) {
			if(a.charAt(i-1)==b.charAt(j-1)) {
				sb.append(a.charAt(i-1));
				i--;
				j--;
			}else {
				if(dp[i-1][j]>dp[i][j-1])i--;
				else j--;
			}
		}
		System.out.println(dp[n][m]);
		System.out.println(sb.reverse().toString());
	}
}
