package 유니온파인드;
import java.util.*;
import java.io.*;
public class Boj7511소셜네트워킹어플리케이션 {
	static int[]parent;
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuffer sb = new StringBuffer();
		int test = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=test;i++) {
			st = new StringTokenizer(bf.readLine());
			int users = Integer.parseInt(st.nextToken());
			parent = new int[users];
			
			for(int k=0;k<users;k++)parent[k]=k;
			
			st = new StringTokenizer(bf.readLine());
			int relation = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<relation;j++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			st = new StringTokenizer(bf.readLine());
			int m = Integer.parseInt(st.nextToken());
			
			sb.append("Scenario "+i+":"+"\n");
			for(int j=0;j<m;j++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(find(a)!=find(b)) {
					sb.append(0+"\n");
				}else sb.append(1+"\n");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	public static void union(int a, int b) {
		int a_p = find(a);
		int b_p = find(b);
		if(a_p!=b_p) {
			if(a_p<b_p)parent[b_p]=a_p;
			else parent[a_p]=b_p;
		}
	}
	public static int find(int a) {
		if(parent[a]==a)return a;
		else {
			return parent[a]=find(parent[a]);
		}
	}
}
