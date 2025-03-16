
import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong();

		long sum = 0;
		int n = 0;
		while(sum+(n+1)<=s) {
			n++;
			sum+=n;
		}
		System.out.println(n);
		sc.close();
	}
}
