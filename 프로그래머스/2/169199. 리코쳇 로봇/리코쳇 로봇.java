import java.util.*;

class Solution {
    // 4방향 이동을 위한 상수
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int n, m;

    // 로봇의 현재 상태를 저장하는 클래스 (위치, 이동 횟수)
    static class Node {
        int x, y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        int startX = 0, startY = 0;
        int goalX = 0, goalY = 0;
        
        // 보드 초기화 및 시작점/도착점 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                } else if (board[i].charAt(j) == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        // 방문 여부를 기록할 2D 배열. 방문하지 않았으면 false.
        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        // 시작점 설정
        visited[startX][startY] = true;
        queue.add(new Node(startX, startY, 0));

        // BFS 탐색
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 목표 지점에 도달했으면 현재 이동 횟수 반환
            if (current.x == goalX && current.y == goalY) {
                return current.count;
            }

            // 4방향으로 미끄러져 이동
            for (int i = 0; i < 4; i++) {
                int nextX = current.x;
                int nextY = current.y;

                // 장애물을 만날 때까지 미끄러짐
                while (true) {
                    int tempX = nextX + dx[i];
                    int tempY = nextY + dy[i];

                    // 보드 경계를 벗어나거나 장애물을 만나면 멈춤
                    if (tempX < 0 || tempX >= n || tempY < 0 || tempY >= m || board[tempX].charAt(tempY) == 'D') {
                        break;
                    }
                    
                    nextX = tempX;
                    nextY = tempY;
                }

                // 미끄러져 멈춘 지점이 현재 위치와 같거나 이미 방문했다면 스킵
                if (visited[nextX][nextY] || (nextX == current.x && nextY == current.y)) {
                    continue;
                }

                // 최종 도착 지점을 방문 처리하고 큐에 추가
                visited[nextX][nextY] = true;
                queue.add(new Node(nextX, nextY, current.count + 1));
            }
        }

        // 목표 지점에 도달할 수 없는 경우
        return -1;
    }
}