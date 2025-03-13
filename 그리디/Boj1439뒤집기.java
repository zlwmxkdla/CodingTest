package 그리디;
import java.io.*;

public class Boj1439뒤집기 {
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		
		int []answer=new int[2];
		if(s.charAt(0)=='0')answer[0]=1;
		else answer[1]=1;
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)!=s.charAt(i-1)) {
				answer[s.charAt(i)-'0']+=1;
			}
		}
		int min=answer[0]<answer[1]?answer[0]:answer[1];
		System.out.print(min);
	}
}
