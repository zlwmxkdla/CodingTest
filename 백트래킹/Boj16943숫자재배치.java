package 백트래킹;
import java.io.*;
import java.util.*;
public class Boj16943숫자재배치 {
	public static int max = Integer.MIN_VALUE;
	public static String A;
	public static long B;
	public static boolean[]visited;
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		A = st.nextToken();
		B = Integer.parseInt(st.nextToken());
		visited= new boolean[A.length()];
		
		
		dfs("",0);
		if(max==Integer.MIN_VALUE)max=-1;
		System.out.println(max);
	}
	public static void dfs(String s,int depth) {
		
		
		if(depth==A.length()) {
			if(s.charAt(0)!=0) {
				int num = Integer.parseInt(s);
				if(num<B) {
					max=Math.max(max, num);
				}
			}
			return;
		}
		
		for(int i=0;i<A.length();i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(s+String.valueOf(A.charAt(i)),depth+1);
				visited[i]=false;
			}
		}
	}
}
