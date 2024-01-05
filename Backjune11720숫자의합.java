package array_and_list;
import java.util.Scanner;

public class Backjune11720숫자의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		String sNum=sc.next();
		
		char[] cNum=sNum.toCharArray();	//String 문자열을 char형 배열로 바꿔주는 메소드 
		int sum=0;
		for(int i=0;i<sNum.length();i++) {
			sum+=cNum[i]-'0';
		}
		
		System.out.print(sum);
		sc.close();
	}

}
