
import java.util.*;
import java.io.*;
public class Main {
	static int N;
    static int[][] board;
    static boolean[][] visited;
    static int minCost = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        backtrack(0, 0);
        System.out.println(minCost);
    }
    
    static void backtrack(int count, int cost) {
        if (count == 3) { // 꽃 3개를 다 심었으면 최소 비용 갱신
            minCost = Math.min(minCost, cost);
            return;
        }
        
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (canPlant(i, j)) { // 해당 위치에 꽃을 심을 수 있는지 확인
                    int nowCost = plantFlower(i, j);
                    backtrack(count + 1, cost + nowCost);
                    removeFlower(i, j); // 백트래킹 (원상 복구)
                }
            }
        }
    }
    
    static boolean canPlant(int x, int y) {
        // 중심과 상하좌우 4칸이 경계 내부인지 확인 + 이미 방문했는지 체크
        if (visited[x][y]) return false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }
    
    static int plantFlower(int x, int y) {
        int cost = board[x][y];
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = true;
            cost += board[nx][ny];
        }
        return cost;
    }
    
    static void removeFlower(int x, int y) {
        visited[x][y] = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = false;
        }
    }
	
}
