import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        visited = new boolean[N][M][N][M];
        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int crx = cur[0], cry = cur[1], cbx = cur[2], cby = cur[3], depth = cur[4];

            if (depth >= 10) return 0;

            for (int d = 0; d < 4; d++) {
                int nrx = crx, nry = cry, nbx = cbx, nby = cby;
                int rMove = 0, bMove = 0;

                // 빨간 구슬 이동
                while (map[nrx + dx[d]][nry + dy[d]] != '#' && map[nrx][nry] != 'O') {
                    nrx += dx[d];
                    nry += dy[d];
                    rMove++;
                    if (map[nrx][nry] == 'O') break;
                }

                // 파란 구슬 이동
                while (map[nbx + dx[d]][nby + dy[d]] != '#' && map[nbx][nby] != 'O') {
                    nbx += dx[d];
                    nby += dy[d];
                    bMove++;
                    if (map[nbx][nby] == 'O') break;
                }

                // 파란 구슬이 구멍에 빠졌으면 실패
                if (map[nbx][nby] == 'O') continue;

                // 빨간 구슬만 빠졌으면 성공
                if (map[nrx][nry] == 'O') return 1;

                // 겹쳤을 때 더 많이 이동한 구슬을 한 칸 뒤로
                if (nrx == nbx && nry == nby) {
                    if (rMove > bMove) {
                        nrx -= dx[d];
                        nry -= dy[d];
                    } else {
                        nbx -= dx[d];
                        nby -= dy[d];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new int[]{nrx, nry, nbx, nby, depth + 1});
                }
            }
        }
        return 0;
    }
}
