package 유니온파인드;
import java.util.*;
public class Boj24541튜터튜티관계의수 {
	static int[]parent;
	static Map<Integer,Integer>map = new HashMap<>();
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		parent = new int[N+1];
		for(int i=0;i<=N;i++)parent[i]=i;
		int M = sc.nextInt();
		for(int i=0;i<M;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			union(u,v);
		}
		for(int i=1;i<=N;i++)map.put(find(i), map.getOrDefault(find(i),0)+1);
		int answer = 1;
		for(Integer value:map.values()) {
			answer*=value;
		}
		System.out.println(answer);
		sc.close();
	}
	public static void union(int a, int b) {
		int top_a = find(a);
		int top_b = find(b);
		
		if(top_a!=top_b) {
			if(top_a<top_b) {
				parent[top_b]=top_a;
			}
			else {
				parent[top_a]=top_b;
			}
		}
		
	}
	public static int find(int a) {
		if(a==parent[a])return a;
		else return parent[a]=find(parent[a]);
	}
}
