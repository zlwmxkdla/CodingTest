import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[] arr;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) break;

            arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, new int[6]);  // 조합 만들기
            answer.append("\n");   // 각 테스트 케이스 구분
        }

        System.out.print(answer);
    }

    public static void dfs(int start, int depth, int[] result) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                answer.append(result[i]).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = start; i < K; i++) {
            result[depth] = arr[i];
            dfs(i + 1, depth + 1, result);
        }
    }
}
