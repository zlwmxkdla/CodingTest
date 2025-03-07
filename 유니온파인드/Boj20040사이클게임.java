package 유니온파인드;
import java.io.*;
import java.util.*;
public class Boj20040사이클게임 {
	static int[]parent;
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer>list = new ArrayList<>();
		list.add(0);
		boolean cycle = false;
		parent=new int[n];
		for(int i=0;i<n;i++)parent[i]=i;
		
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(find(a)==find(b)) {
				list.add(i);
				cycle = true;
			}
			union(a,b);
		}
		if(cycle)System.out.println(list.get(1));
		else System.out.println(0);
	}
	public static void union(int a, int b) {
		int root_a = find(a);
		int root_b = find(b);
		if(root_a!=root_b) {
			if(root_a<root_b)parent[root_b]=root_a;
			else parent[root_a]=root_b;
		}
	}
	public static int find(int a) {
		if(a==parent[a])return a;
		else return parent[a]=find(parent[a]);
	}
}
