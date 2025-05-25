import java.util.*;

class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int sub1;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 리스트 초기화
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // 그래프 구성
        for (int[] wire : wires) {
            int from = wire[0] - 1;
            int to = wire[1] - 1;
            list.get(from).add(to);
            list.get(to).add(from);
        }

        // 전선 하나씩 끊어보며 최소 차이 탐색
        for (int[] wire : wires) {
            int from = wire[0] - 1;
            int to = wire[1] - 1;

            // 전선 끊기
            list.get(from).remove(Integer.valueOf(to));
            list.get(to).remove(Integer.valueOf(from));

            // 차이 계산
            visited = new boolean[n];
            sub1 = 1;
            visited[from] = true;
            dfs(from);
            int sub2 = n - sub1;
            answer = Math.min(answer, Math.abs(sub1 - sub2));

            // 다시 연결
            list.get(from).add(to);
            list.get(to).add(from);
        }

        return answer;
    }

    public void dfs(int node) {
        for (int next : list.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                sub1++;
                dfs(next);
            }
        }
    }
}
