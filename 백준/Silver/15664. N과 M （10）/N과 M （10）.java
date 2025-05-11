
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);  // 오름차순 정렬

        visited = new boolean[N];
        dfs(0, 0, new StringBuilder());
        System.out.print(sb);
    }

    public static void dfs(int start, int depth, StringBuilder current) {
        if (depth == M) {
            sb.append(current).append("\n");
            return;
        }

        int prev = -1;  // 이전에 사용한 수를 기록
        for (int i = start; i < N; i++) {
            if (!visited[i] && arr[i] != prev) {  // 중복 방지
                visited[i] = true;
                current.append(arr[i]).append(" ");
                dfs(i + 1, depth + 1, current);
                current.setLength(current.length() - (String.valueOf(arr[i]).length() + 1));  // 이전 상태로 되돌리기
                visited[i] = false;
                prev = arr[i];  // 이전 수 업데이트
            }
        }
    }
}
