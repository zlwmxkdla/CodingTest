
import java.util.*;
public class Main {
	static int n,answer=-1;
	static List<Integer>[]list;
	static boolean[]visited;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int x = sc.nextInt();//촌수를 구해야 하는 사람 두명 
		int y = sc.nextInt();
		
		list = new List[n+1];
		for(int i=1;i<=n;i++)list[i]=new LinkedList<>();
		visited = new boolean[n+1];
		
		int m = sc.nextInt();
		for(int i=0;i<m;i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			list[parent].add(child);
			list[child].add(parent);
		}
		
		dfs(x,y,0);
		
		System.out.println(answer);
	}
	public static void dfs(int x, int y, int depth) {
		visited[x]=true;
		if(x==y) {
			answer = depth;
			return;
		}
		for(Integer e : list[x]) {
			if(!visited[e]) {
				dfs(e,y,depth+1);
			}
		}
	}
}
