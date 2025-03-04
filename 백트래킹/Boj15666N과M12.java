package 백트래킹;
import java.util.*;
public class Boj15666N과M12 {
	static int N,M;
	static int[]arr;
	static StringBuffer sb=new StringBuffer();;
	static List<Integer>list;
	static Set<String> set=new LinkedHashSet<>();
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++)arr[i]=sc.nextInt();
		
		Arrays.sort(arr);
		
		dfs(0,0,new ArrayList<>());
		System.out.println(sb);
		sc.close();
	}
	public static void dfs(int start,int depth, List<Integer>list) {
		if(depth==M) {
			for(Integer e:list)sb.append(e).append(" ");
			sb.append("\n");
			return;
		}
		int prev=-1;
		for(int i=start;i<N;i++) {
			if(arr[i]!=prev) {
				list.add(arr[i]);
				dfs(i,depth+1,list);
				list.remove(list.size()-1);
				prev = arr[i];
			}
			
		}
	}
}
