package 그리디;

import java.util.*;
public class Boj2720세탁소사장동혁 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		int[][]answer = new int[test][4];
		sc.nextLine();
		for(int i=0;i<test;i++) {
			int remain = Integer.parseInt(sc.nextLine().trim());
		
			double dollar = remain/100.0;
			
			int quarter = (int)(dollar/0.25);
			dollar = dollar - quarter*0.25;

			int dime = (int)(dollar/0.10);
			dollar = dollar - dime*0.10;

			int nickel = (int)(dollar/0.05);
			dollar = dollar - nickel*0.05;

			int penny = (int)(dollar/0.01);
			dollar = dollar - penny*0.01;
			if(penny>0)penny+=1;
			answer[i][0]=quarter;
			answer[i][1]=dime;
			answer[i][2]=nickel;
			answer[i][3]=penny;
		}
		for(int i=0;i<test;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
