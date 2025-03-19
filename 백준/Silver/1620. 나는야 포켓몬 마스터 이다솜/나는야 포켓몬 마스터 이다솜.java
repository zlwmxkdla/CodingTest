
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		Map<String,Integer> namemap = new HashMap<>();
		Map<Integer,String> nummap = new HashMap<>();
		for(int i=0;i<N;i++) {
			String pock = br.readLine();
			namemap.put(pock,i+1);
			nummap.put(i+1, pock);
		}
		for(int i=0;i<M;i++) {
			String find=br.readLine();
			if(isInteger(find)) {
				sb.append(nummap.get(Integer.parseInt(find))+"\n");
			}
			else sb.append(namemap.get(find)+"\n");
		}
		System.out.println(sb.toString());
		
	}
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}
