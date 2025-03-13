package 그리디;
import java.util.*;
public class Boj11047동전개수의최솟값구하기 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[]arr = new int[N];
		for(int i=0;i<N;i++) {
			int price = sc.nextInt();
			arr[i]=price;
		}
		
		int answer = 0;
		for(int j=N-1;j>=0;j--) {
			if(K/arr[j]>0) {
				answer+=(K/arr[j]);
				K%=arr[j];
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
