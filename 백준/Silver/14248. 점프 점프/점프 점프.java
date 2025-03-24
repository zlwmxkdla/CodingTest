
import java.util.*;
public class Main {
	static int n;
	static boolean[]visited;
	static int[]arr;
	static int answer=0;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr=new int[n+1];
		visited = new boolean[n+1];
		for(int i=1;i<=n;i++)arr[i]=sc.nextInt();
		
		int start = sc.nextInt();
		dfs(start);
		System.out.println(answer+1);
		sc.close();
	}
	public static void dfs(int now) {
		visited[now]=true;
		if(now-arr[now]>0 && !visited[now-arr[now]]) {
			answer+=1;
			dfs(now-arr[now]);
		}
		if(now+arr[now]<=n&&!visited[now+arr[now]]) {
			answer+=1;
			dfs(now+arr[now]);
		}
	}
}
