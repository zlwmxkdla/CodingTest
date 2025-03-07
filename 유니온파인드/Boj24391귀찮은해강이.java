package 유니온파인드;
import java.util.*;
public class Boj24391귀찮은해강이 {
	static int[]parent;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		parent = new int[N+1];
		for(int i=0;i<=N;i++)parent[i]=i;
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a,b);
		}
		int[]schedule = new int[N];
		for(int i=0;i<N;i++) {
			schedule[i]=sc.nextInt();
		}
		
		int answer = 0;
		for(int i=0;i<N-1;i++) {
			if(find(schedule[i])==find(schedule[i+1])) {
				//같은 건물이라면
				continue;
			}
			answer++;
		}
		System.out.println(answer);
		sc.close();
	}
	public static void union(int a, int b) {
		int top_a = find(a);
		int top_b = find(b);
		if(top_a!=top_b) {
			parent[top_b]=top_a;
		}
	}
	public static int find(int start) {
		if(start==parent[start])return start;
		return parent[start]=find(parent[start]);
	}
}
