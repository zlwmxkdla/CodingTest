package 탐색;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;

public class Backjune11403경로찾기 {
	static int[][]arr; //방향 그래프 인접 행렬
	static int[][]answer; //결과 출력할 2차원 배열
	static boolean[]visited; //탐색 여부 체크
	static int node; //정점의 개수
	
	
	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		node=Integer.parseInt(st.nextToken());
		
		arr=new int[node+1][node+1];
		answer=new int[node+1][node+1];
		visited=new boolean[node+1];
		
		for(int i=1;i<node+1;i++) {
			for(int j=1;j<node+1;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<node+1;i++) {
			for(int j=1;j<node+1;j++) {
				if(arr[i][j]==1) {
					dfs(arr[i][j]);
				}
			}
		}
	}
	
	static void dfs(int start) {
		for(int i=1;i<node+1;i++) {
			if(visited[i])continue;
			if(arr[start][i]==0)continue;
			
		}
	}
}
