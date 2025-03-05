
import java.util.*;
public class Main {
	static int[]arr;
	static int[]op;
	static int N;
	static int plus,minus,multiple,divide;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		for(int i=0;i<N;i++)arr[i]=sc.nextInt();
		op = new int[4];
		for(int i=0;i<4;i++)op[i]=sc.nextInt();
		
		
		dfs(1,op,arr[0]);
		System.out.println(max);
		System.out.println(min);
		sc.close();
	}
	public static void dfs(int depth,int[]op,int sum) {
		if(depth==N) {//수열의 모든 수를 합산했을 때
			max=Math.max(max,sum);
			min=Math.min(min, sum);
			return;
		}
		for(int i=0;i<4;i++) {
			if(op[i]==0)continue;
			op[i]-=1;
			switch(i) {
				case 0:
					dfs(depth+1,op,sum+arr[depth]);
					break;
				case 1:
					dfs(depth+1,op,sum-arr[depth]);
					break;
				case 2:
					dfs(depth+1,op,sum*arr[depth]);
					break;
				case 3:
					if(sum<0)dfs(depth+1,op,(-1)*((-1)*sum/arr[depth]));
					else dfs(depth+1,op,sum/arr[depth]);
					break;
			}
			op[i]+=1;
		}
	}
}
