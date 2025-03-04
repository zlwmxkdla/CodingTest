package 백트래킹;
import java.util.*;
import java.io.*;
public class Boj6603로또 {
	static int[]arr;
	static boolean[]visited;
	static int k;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(bf.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0)break;
			arr = new int[k];
			visited = new boolean[k];
			for(int i=0;i<k;i++)arr[i]=Integer.parseInt(st.nextToken());
			
			dfs(0, 0, new ArrayList<>());
            sb.append('\n'); // 각 테스트 케이스 사이에 줄바꿈 추가
		}
		System.out.println(sb);
	}
	public static void dfs(int start, int depth, List<Integer> list) {
		if (depth == 6) { // 로또 번호 6개 선택 완료
            for (int num : list) sb.append(num).append(" ");
            sb.append('\n');
            return;
        }

        for (int i = start; i < k; i++) {
            list.add(arr[i]); // 숫자 선택
            dfs(i + 1, depth + 1, list); // 다음 숫자 선택
            list.remove(list.size() - 1); // 백트래킹 (선택 취소)
        }
	}
}
