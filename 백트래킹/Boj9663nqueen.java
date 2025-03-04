package 백트래킹;
import java.util.*;
public class Boj9663nqueen {
	static int n;
	static int[]board;
	static int answer=0;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		board = new int[n];
		NQueen(0);//첫 번째 행부터 시작
		System.out.println(answer);
		sc.close();
	}
	public static void NQueen(int row) {
		if(row==n) {
			//모든 행에 퀸을 놓았을 경우
			answer+=1;
			return;
		}
		for(int i=0;i<n;i++) {//현재 행의 각 열을 시도
			board[row]=i;
			if(isPromising(row)) {
				NQueen(row+1);
			}
		}
	}
	public static boolean isPromising(int row) {
		for(int i=0;i<row;i++) {
			//같은 열에 있거나 대각선에 있는 경우
			if(board[i]==board[row]||Math.abs(board[i]-board[row])==Math.abs(i-row))return false;
		}
		return true;
	}
}
