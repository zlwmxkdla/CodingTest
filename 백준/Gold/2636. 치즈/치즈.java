import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        int time = 0;       // 총 라운드 수
        int lastMelt = 0;   // 마지막 라운드에서 녹인 치즈 수

        while (true) {
            int melted = meltOneRound(); // 이번 라운드에 녹인 개수
            if (melted == 0) break;      // 더 이상 녹일 치즈가 없으면 종료
            lastMelt = melted;
            time++;
        }

        System.out.println(time + " " + lastMelt);
    }

    // 외부 공기 BFS를 통해 이번 라운드에 녹을 치즈를 찾아 녹이고, 그 개수를 반환
    static int meltOneRound() {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        List<int[]> toMelt = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;

                // 공기이면 계속 확장
                if (grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
                // 치즈면 이번 라운드에 녹을 후보
                else if (grid[nx][ny] == 1) {
                    visited[nx][ny] = true; // 다시 처리되지 않도록 방문 체크
                    toMelt.add(new int[]{nx, ny});
                }
            }
        }

        // 실제로 치즈 녹이기
        for (int[] p : toMelt) {
            grid[p[0]][p[1]] = 0;
        }
        return toMelt.size();
    }
}
