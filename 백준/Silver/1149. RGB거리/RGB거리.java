
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[][] arr =new int[n][3];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			arr[i][2]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<n;i++) {
			arr[i][0]+=Math.min(arr[i-1][1], arr[i-1][2]);
			arr[i][1]+=Math.min(arr[i-1][0], arr[i-1][2]);
			arr[i][2]+=Math.min(arr[i-1][0], arr[i-1][1]);
		}
		
		int answer = Math.min(arr[n-1][0], Math.min(arr[n-1][1], arr[n-1][2]));
		System.out.print(answer);
	}
}
