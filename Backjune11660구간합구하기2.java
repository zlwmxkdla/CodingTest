package 구간합;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Backjune11660구간합구하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int size=Integer.parseInt(st.nextToken());
		int num=Integer.parseInt(st.nextToken());
		
		int [][]array=new int[size][size];
		int [][]sum=new int[size][size];
		for(int i=0;i<size;i++) {	//배열 초기화하기
			StringTokenizer str=new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				array[i][j]=Integer.parseInt(str.nextToken());
				sum[i][j]=array[i][j];
				if(j!=0) {
					sum[i][j]=sum[i][j-1]+array[i][j];
				}
			}
		}
		
		for(int i=0;i<num;i++) {
			StringTokenizer str=new StringTokenizer(br.readLine());
			int start_row=Integer.parseInt(str.nextToken());
			int start_col=Integer.parseInt(str.nextToken());
			int end_row=Integer.parseInt(str.nextToken());
			int end_col=Integer.parseInt(str.nextToken());
			
			
			if(start_row==end_row) {
				if(start_col==1) {
					System.out.println(sum[start_row-1][end_col-1]-sum[start_row-1][0]);	
				}
				System.out.println(sum[start_row-1][end_col-1]-sum[start_row-1][start_col-2]);
			}
			else {
				int summ=0;
				if(start_col==1) {
					for(int k=start_row-1;k<=end_row-1;k++) {
						summ+=(sum[k][end_col-1]);
					}	
				}
				else {
					for(int k=start_row-1;k<=end_row-1;k++) {
						summ+=(sum[k][end_col-1]-sum[k][start_col-2]);
					}
				}
				
				System.out.println(summ);
			}
		}
	}
}
