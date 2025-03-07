package 유니온파인드;
import java.io.*;
import java.util.*;
public class Boj1976여행가자 {
	static int num;
	static int[][]arr;
	static int[]parent;
	public static void main(String[]args)throws IOException{
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[num+1][num+1];
		parent = new int[num+1];
		for(int i=1;i<=num;i++)parent[i]=i;
		
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=num;j++) {
				int now = sc.nextInt();
				arr[i][j]=now;
			}
		}
		int[]route = new int[M+1];
		for(int i=1;i<=M;i++)route[i]=sc.nextInt();
		
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=num;j++) {
				if(arr[i][j]==1)union(i,j);
			}
		}
		int start = find(route[1]);
		for(int i=2;i<=M;i++) {
			if(start != find(route[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa!=pb) {
			parent[pb]=pa;
		}
	}
	public static int find(int a) {
		if(parent[a]==a) return a;
		return parent[a]=find(parent[a]);
	}
}
