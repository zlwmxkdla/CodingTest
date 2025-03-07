package 유니온파인드;
import java.io.*;
import java.util.*;
public class Boj1043거짓말 {
	static int N,M;
	static int[]parent;
	static int[]trueP;
	static ArrayList<Integer>[]party;
	static int result=0;
	@SuppressWarnings("unchecked")
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int i=1;i<=N;i++)parent[i]=i;//대표 노드를 자기 자신으로 초기화하기
		
		//진실을 아는 사람 저장하기
		st = new StringTokenizer(bf.readLine());
		int TrueCount=Integer.parseInt(st.nextToken());
		trueP = new int[TrueCount];
		for(int i=0;i<TrueCount;i++)trueP[i]=Integer.parseInt(st.nextToken());
		
		//파티 데이터 저장하기
		party = new ArrayList[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			party[i]= new ArrayList<Integer>();
			int party_size = Integer.parseInt(st.nextToken());
			for(int j=0;j<party_size;j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		//각 파티에 참여한 사람들을 1개의 그룹으로 만들개
		for(int i=0;i<M;i++) {
			int firstPeople = party[i].get(0);
			for(int j=1;j<party[i].size();j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		//각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없음
		for(int i=0;i<M;i++) {
			boolean isPossible = true;
			int cur = party[i].get(0);
			for(int j=0;j<trueP.length;j++) {
				if(find(cur)==find(trueP[j])) {
					isPossible = false;
					break;
				}
			}
			if(isPossible)result++;
		}
		System.out.println(result);
	}
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b)parent[b]=a;
	}
	public static int find(int a) {
		if(a==parent[a])return a;
		else return parent[a]=find(parent[a]);
	}
	public static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b)return true;
		return false;
	}
}
