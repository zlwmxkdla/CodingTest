
import java.util.Scanner;
public class Main {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		
		int num=sc.nextInt();
		int []answer=new int[num];
		for(int i=0;i<num;i++) {
			int K=sc.nextInt();
			int N=sc.nextInt();
			int [][]arr=new int[K+1][15];
			
			for(int j=1;j<=N;j++) {
				arr[0][j]=j;
			}
			for(int j=1;j<=K;j++) {
				arr[j][0]=arr[j-1][0];
				for(int s=1;s<=N;s++) {
					arr[j][s]=arr[j][s-1]+arr[j-1][s];
				}
			}
			answer[i]=arr[K][N];
		}
		for(int i=0;i<num;i++)System.out.println(answer[i]);
		sc.close();
	}
}
