import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] inc = new int[n];  // 오름차순
		int[] dec = new int[n];  // 내림차순
		
		Arrays.fill(inc, 1);
		Arrays.fill(dec, 1);
		
		int answer = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] >= arr[i - 1]) inc[i] = inc[i - 1] + 1;
			if (arr[i] <= arr[i - 1]) dec[i] = dec[i - 1] + 1;
			
			answer = Math.max(answer, Math.max(inc[i], dec[i]));
		}
		
		System.out.println(answer);
	}
}
