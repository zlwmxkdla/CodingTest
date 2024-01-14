package 투포인터;
import java.util.Scanner;

public class Backjune2018연속된자연수의합구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int count=1;//자기 자신은 항상 포함되므로
		int start,end,end_index,s;
		
		//부분합 구하기
		int []sum=new int[n];
		sum[0]=1;
		for(int i=1;i<n;i++) {
			sum[i]=sum[i-1]+(i+1);
		}
		
		if(n%2!=0) {
			count+=1;
		}
		end=n/2-1;
		end_index=end-1;
		
		
		for(int k=end_index;k>0;k--) {
			for(s=k-1;s>0;s--) {
				if(sum[k]-sum[s-1]==n) {
					count+=1;
				}
				
			}
			if(s==0) {
				if(sum[k]==n) {
					count+=1;
				}
			}
		}
		
		
		System.out.println(count);
		sc.close();
	}

}

