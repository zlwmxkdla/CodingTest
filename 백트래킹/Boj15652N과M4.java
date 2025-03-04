package 백트래킹;
import java.util.*;
public class Boj15652N과M4 {
	public static int N,M;
	public static int[]arr;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr = new int[M];
		
		dfs(1,0);
		sc.close();
	}
	public static void dfs(int j,int depth) {
		if(depth>=M) {
			for(int element:arr) {
				System.out.print(element+" ");
			}System.out.println();
			return;
		}
		
		for(int i=j;i<=N;i++) {
			arr[depth]=i;
			dfs(i,depth+1);
		}
	}
}
