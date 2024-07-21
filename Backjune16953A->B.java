package 탐색;

import java.util.*;

public class Backjune16953AB {
	static int A,B;
	public static void main(String[]args) {
		try (Scanner sc = new Scanner(System.in)) {
			A=sc.nextInt();
			B=sc.nextInt();
		}
		
		Queue <long[]>queue=new LinkedList<>();
		queue.add(new long[]{A,1});
		while(!queue.isEmpty()) {
			long []current=queue.poll();
			long current_number=current[0];
			long current_count=current[1];
			
			if(current_number==B) {
				System.out.print(current_count);
				return;
			}
			
			long next_number1=current_number*2;
			long next_number2=current_number*10+1;
			
			if(next_number1<=B)queue.add(new long[] {next_number1,current_count+1});
			if(next_number2<=B)queue.add(new long[] {next_number2,current_count+1});
			
		}
		System.out.print("-1");
		return;
	}
}
