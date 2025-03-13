package 그리디;
import java.util.*;
import java.io.*;
public class Boj11399ATM {
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int []arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		for(int i=1;i<n;i++) {
			arr[i]+=arr[i-1];
		}
		int answer=0;
		for(int i=0;i<n;i++)answer+=arr[i];
		System.out.print(answer);
	}
}
