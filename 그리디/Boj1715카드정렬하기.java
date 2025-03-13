package 그리디;
import java.util.*;
public class Boj1715카드정렬하기 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			int num = sc.nextInt();
			pq.add(num);
		}
		int answer = 0;
		int temp=0;
		
		while(!pq.isEmpty()){
			
			if(pq.size()==2) {
				temp+=pq.poll();
				temp+=pq.poll();
				answer+=temp;
			
				break;
			
			}else if(pq.size()==1){
				
				break;
			}else {
				temp += pq.poll();
				temp += pq.poll();

				answer+=temp;
				pq.add(temp);
				temp=0;
			}
			
		}
		System.out.println(answer);
		sc.close();
	}
}
