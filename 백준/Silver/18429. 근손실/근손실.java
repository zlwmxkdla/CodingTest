import java.io.*;
import java.util.*;

public class Main {
	static int N, K, answer = 0;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[N];
		dfs(0, 500); // depth 0, weight 500에서 시작
		System.out.println(answer);
	}

	public static void dfs(int depth, int currentWeight) {
		if (currentWeight < 500) return;
		if (depth == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int nextWeight = currentWeight + arr[i] - K;
				dfs(depth + 1, nextWeight);
				visited[i] = false; // 백트래킹
			}
		}
	}
}
