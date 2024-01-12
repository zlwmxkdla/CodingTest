package 구간합;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjune10986나머지합구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int []array=new int[n];
		for(int i=0;i<n;i++) {
			array[i]=st.nextToken();
		}
		int sum=0;
		for(int i=1;i<n;i++) {
			int []sum_array=new int[n];
			sum_array[i-1]=array[i-1];
			for(int j=i;j<n;j++) {
				sum_array[j]=sum_array[j-1]+array[j];
			}
			for(int k=0;k<n;k++) {
				if(sum_array[k]%m==0) {
					sum+=1;
				}
			}
		}
		
		
	}

}
