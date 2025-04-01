
import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int[]arr = new int[6];
		for(int i=1;i<=5;i++) {
			arr[i]=sc.nextInt();
		}
		
		while(true) {
			//정렬 완료 여부 확인하기
			boolean sorted=true;
			for(int i=1;i<=5;i++) {
				if(arr[i]!=i) {
					sorted=false;
					break;
				}
			}
			if(sorted) break;
			
			for(int i=1;i<=4;i++) {
				if(arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
					for(int j=1;j<=5;j++) {
						System.out.print(arr[j]+" ");
					}
					System.out.println();
				}
				
			}
		}
	}
}
