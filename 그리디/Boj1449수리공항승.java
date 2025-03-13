package 그리디;
import java.io.*;
import java.util.*;
public class Boj1449수리공항승 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		int[]water = new int[num];
		int line = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<num;i++)water[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(water);
		
		int answer=0;
		int i=0;
		while(i<num) {
			answer++;
			int coverEnd = water[i]+line-1;
			
			while(i<num&&water[i]<=coverEnd)i++;
		}
		System.out.println(answer);
	}
}
