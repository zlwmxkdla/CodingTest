
import java.io.*;
import java.util.*;
public class Main {
	public static int N,S,answer=0;
	public static int[]arr;
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)arr[i]=Integer.parseInt(st.nextToken());
		
		dfs(0,0);
		
		if (S == 0) {
            answer--;
        }
		System.out.print(answer);
	}
	public static void dfs(int sum,int index) {
		if(index==N) {
			if(sum==S)answer++;
			return;
		}
		dfs(sum+arr[index],index+1);
		dfs(sum,index+1);
	}
}
