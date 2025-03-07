package 유니온파인드;
import java.io.*;
import java.util.*;
public class Boj1717집합표현하기 {
	static int n,m;
	static int[]arr;
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		for(int i=0;i<arr.length;i++)arr[i]=i;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(bf.readLine());
			int operand = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(operand==0) {
				//합치는 연산
				int a_captin = find(a);
				int b_captin = find(b);
				if(a_captin!=b_captin)arr[b_captin]=a_captin;
			}else {
				if(find(a)==find(b)) {
					sb.append("YES");
					sb.append("\n");
				}else {
					sb.append("NO");
					sb.append("\n");
				}
			}
			
		}
		System.out.println(sb);
	}
	public static int find(int a) {
		int index = a;
		Stack<Integer> stack = new Stack<>();
		while(arr[index]!=index) {
			stack.add(index);
			index = arr[index];
		}
		while(!stack.isEmpty()) {
			int e = stack.pop();
			arr[e]=index;
		}
		return index;
	}
}
