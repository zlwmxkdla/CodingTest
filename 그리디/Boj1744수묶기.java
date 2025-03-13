package 그리디;
import java.util.*;
public class Boj1744수묶기 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		PriorityQueue<Integer> minus_pq = new PriorityQueue<>();
		PriorityQueue<Integer> zero_pq = new PriorityQueue<>();
		PriorityQueue<Integer> plus_pq = new PriorityQueue<>(Collections.reverseOrder());
		int answer=0;
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			if(num<0)minus_pq.add(num);
			else if(num==0)zero_pq.add(num);
			else if(num==1) answer+=1;
			else plus_pq.add(num);
		}
		
		
		if(minus_pq.size()!=0) {
			while(!minus_pq.isEmpty()) {
				int s = minus_pq.poll();
				if(minus_pq.isEmpty()) {
					if(zero_pq.size()!=0) {
						zero_pq.poll();
						break;
					}else {
						answer+=s;
						break;
					}
				}
				int e = minus_pq.poll();
				answer+=(s*e);
			}
		}
		
		if(plus_pq.size()!=0) {
			while(!plus_pq.isEmpty()) {
				int s = plus_pq.poll();
				if(plus_pq.isEmpty()) {
					answer+=s;
					break;
				}
				int e = plus_pq.poll();
				answer+=(s*e);
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
