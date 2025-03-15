import java.util.*;
public class Main {
	static int[]arr;
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		Map<Integer,Integer> map = new HashMap<>();
		arr = new int[N];
		for(int i =0;i<N;i++) {
			int n=sc.nextInt();
			arr[i]=n;
			map.put(n, map.getOrDefault(n, 0)+1);
		}
		int M = sc.nextInt();
		for(int i=0;i<M;i++) {
			int find = sc.nextInt();
			if(map.containsKey(find)) {
				sb.append(map.get(find)+" ");
			}else {
				sb.append(0+" ");
			}
		}
        System.out.print(sb.toString());
		sc.close();
	}
	
}
