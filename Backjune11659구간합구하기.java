package 구간합;
import java.util.Scanner;

public class Backjune11659구간합구하기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int time=sc.nextInt();
		int nums[]=new int[N];
		for(int i=0;i<N;i++) {
			nums[i]=sc.nextInt();
		}
		int sum[]=new int[N];
		sum[0]=nums[0];
		for(int i=1;i<N;i++) {
			sum[i]=sum[i-1]+nums[i]; //부분합
		}
		int result[]=new int[time];
		for(int i=0;i<time;i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			start-=1;
			end-=1;
			if(start==0) {
				result[i]=sum[end];
			}
			else {
				result[i]=sum[end]-sum[start-1];
			}
		}
		for(int i=0;i<time;i++) {
			System.out.println(result[i]);
		}
	}
}
