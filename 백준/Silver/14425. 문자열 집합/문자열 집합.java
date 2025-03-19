
import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Set<String> set = new HashSet<>();
		for(int i=0;i<N;i++) {
			String include = sc.next();
			set.add(include);
		}
		int answer = 0;
		for(int i=0;i<M;i++) {
			String find = sc.next();
			if(set.contains(find))answer+=1;
		}
		System.out.println(answer);
		sc.close();
	}
}
