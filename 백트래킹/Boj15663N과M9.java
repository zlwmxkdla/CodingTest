package 백트래킹;
import java.util.*;
public class Boj15663N과M9 {
	static int []arr;
	static boolean [] visited;
	static Set<String> set=new LinkedHashSet<>();
	static int N,M;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++)arr[i]=sc.nextInt();
		Arrays.sort(arr);
		visited = new boolean[N];
		dfs(0,new ArrayList<>());
		for(String s:set)System.out.println(s);
		sc.close();
	}
	public static void dfs(int depth, List<Integer>list) {
		if(depth==M) {
			StringBuffer sb = new StringBuffer();
			for(int num:list) {
				sb.append(num).append(" ");
			}
			set.add(sb.toString());
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				list.add(arr[i]); // 숫자 선택
	            dfs(depth + 1, list); // 다음 숫자 선택
	            list.remove(list.size() - 1); // 백트래킹 (선택 취소)
	            visited[i]=false;
			}
            
        }
	}
}
