package 그리디;
import java.io.*;
import java.util.*;
public class Boj1026보물 {
	public static void main(String[]args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		int[]A=new int[N];
		Integer []B=new Integer [N];
		for(int i=0;i<N;i++) {
			A[i]=sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			B[i]=sc.nextInt();
		}
		Arrays.sort(A);
		Arrays.sort(B,Collections.reverseOrder());
		int answer=0;
		for(int i=0;i<N;i++) {
			answer+=(A[i]*B[i]);
		}
		System.out.print(answer);
		sc.close();
	}
}
