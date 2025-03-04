package 이분탐색;
import java.util.*;
public class Boj2110공유기설치 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[]arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		int result = 0;
		int left = 1;//최소 인접 거리
		int right = arr[N-1]-arr[0];//최대 인접 거리
		while(left<=right) {
			int mid = (left+right)/2;
			if(getPossibleCnt(arr,mid)>=C) {
				//공유기가 더 많이 설치되는 경우이므로 인접 거리를 늘려야 한다.
				left = mid+1;
				result = Math.max(result, mid);
			}else {
				//공유기가 적게 설치되므로 인접 거리를 줄이자
				right = mid-1;
			}
		}
		System.out.println(result);
		sc.close();
	}
	public static int getPossibleCnt(int[]houses,int diff) {
		//해당 인접 거리로 공유기를 설치했을 때 설치 가능한 공유기의 개수
		int possibleCnt = 1;
		int prev = houses[0];
		for(int i=0;i<houses.length;i++) {
			if(houses[i]-prev>=diff) {
				prev=houses[i];
				possibleCnt+=1;
			}
		}
		return possibleCnt;
	}
}
