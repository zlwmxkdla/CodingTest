
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int[]type = new int[M];
		int total = 0;
		for(int i=0;i<M;i++) {
			type[i]=Integer.parseInt(st.nextToken());
			total+=type[i];
		}
		
		int K = Integer.parseInt(bf.readLine());
		double proprities[]=new double[M];
		double answer = 0.0;
		for(int i=0;i<M;i++) {
			if(type[i]>=K) {
				proprities[i]=1.0;
				for(int k=0;k<K;k++) {
					proprities[i]*=(double)(type[i]-k)/(total-k);
				}
				answer += proprities[i];
			}
		}
		System.out.println(answer);
		 
	}
}
