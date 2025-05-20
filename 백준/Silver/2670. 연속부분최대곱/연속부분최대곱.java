
import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[]arr = new double[N];
		for(int i=0;i<N;i++)arr[i]=sc.nextDouble();
		double[]dp=new double[N];
		double max = 0;
		dp[0]=arr[0];
		for(int i=1;i<N;i++) {
			dp[i]=Math.max(dp[i-1]*arr[i], arr[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(String.format("%.3f",max));
		sc.close();
	}
}
