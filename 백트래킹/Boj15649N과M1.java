package 백트래킹;
import java.util.*;
public class Boj15649N과M1 {
	public static int N,M;
	public static int[]arr;
	public static boolean[]visited;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		visited = new boolean[N+1];
		
		find(0);
		sc.close();
	}
	public static void find(int depth) {
		if(depth>=M) {
			for(int item:arr) {
				System.out.print(item+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				arr[depth]=i;
				visited[i]=true;
				find(depth+1);
				visited[i]=false;
			}
		}
	}
}
