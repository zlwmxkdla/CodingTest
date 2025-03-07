package 유니온파인드;
import java.util.*;
public class Boj1717집합표현하기복습250213 {
	static int[]arr;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		
		arr = new int[n+1];
		for(int i=0;i<=n;i++)arr[i]=i;
		for(int i=0;i<m;i++) {
			int operand = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(operand==0) {
				union(a,b);
			}else if(operand==1) {
				int a_top = find(a);
				int b_top = find(b);
				if(a_top==b_top) {
					sb.append("YES");
					sb.append("\n");
				}else {
					sb.append("NO");
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);
		sc.close();
	}
	public static void union(int a, int b) {
		int a_top = find(a);
		int b_top = find(b);
		if(a_top!=b_top) {
			arr[b_top]=a_top;
		}
	}
	public static int find(int a) {
		if(arr[a]==a)return a;
		else 
			return arr[a]=find(arr[a]);
	}
}
