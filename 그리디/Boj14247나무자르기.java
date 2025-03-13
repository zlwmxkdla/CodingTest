package 그리디;
import java.io.*;
import java.util.*;
public class Boj14247나무자르기 {
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            result += Integer.parseInt(st.nextToken());
        }

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        for (int i = 0; i < n; i++) {
            result += (long)A[i] * i;
        }

        System.out.println(result);
    
	}
}
