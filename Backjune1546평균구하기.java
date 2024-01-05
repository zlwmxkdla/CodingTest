package array_and_list;
import java.util.Scanner;

public class Backjune1546평균구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int num=sc.nextInt();
		int []scores=new int[num];
		for(int i=0;i<num;i++) {
			scores[i]=sc.nextInt();
		}
		
		int max=-1;
		int sum=0;
		for(int i=0;i<num;i++) {
			sum+=(scores[i]);
			if(scores[i]>max) {
				max=scores[i];
			}
		}
		
		double result=sum*100.0/max/num;
		System.out.print(result);
		sc.close();
	}

}
