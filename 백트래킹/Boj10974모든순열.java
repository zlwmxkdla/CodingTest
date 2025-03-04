package 백트래킹;
import java.util.*;
public class Boj10974모든순열 {
	static int N;
	static boolean[]visited;
	static int[]arr;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new boolean[N+1];
		arr = new int[N];
		
		dfs(0);
		
		sc.close();
	}
	public static void dfs(int depth) {
		if(depth==N) {
			for(int i:arr)System.out.print(i+" ");
			System.out.println();
			return;
		}
		//1부터 N까지 숫자 선택
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[depth]=i;
				dfs(depth+1);
				visited[i]=false;
			}
		}
	}
}
