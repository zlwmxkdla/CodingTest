import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        for (int i = 0; i < places.length; i++) {
            boolean right = true; // 거리두기 여부
            char[][] grid = new char[5][5];
            List<int[]> people = new ArrayList<>();

            // 대기실 상태 입력
            for (int j = 0; j < 5; j++) {
                String line = places[i][j];
                for (int k = 0; k < 5; k++) {
                    grid[j][k] = line.charAt(k);
                    if (grid[j][k] == 'P') {
                        people.add(new int[]{j, k});
                    }
                }
            }

            // 각 사람마다 BFS로 거리두기 확인
            for (int[] p : people) {
                if (!right) break; // 이미 위반이면 더 볼 필요 없음

                Queue<int[]> q = new LinkedList<>();
                boolean[][] visited = new boolean[5][5];
                q.add(new int[]{p[0], p[1], 0});
                visited[p[0]][p[1]] = true;

                while (!q.isEmpty()) {
                    int[] now = q.poll();
                    int x = now[0], y = now[1], d = now[2];

                    for (int j = 0; j < 4; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        int nd = d + 1;

                        if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                        if (visited[nx][ny] || nd > 2) continue;
                        if (grid[nx][ny] == 'X') continue; // 파티션은 막힘

                        // 사람을 만났는데 거리 ≤2면 거리두기 위반
                        if (grid[nx][ny] == 'P') {
                            right = false;
                            break;
                        }

                        // 빈 자리라면 탐색 계속
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, nd});
                    }

                    if (!right) break;
                }
            }

            answer[i] = right ? 1 : 0;
        }

        return answer;
    }
}
