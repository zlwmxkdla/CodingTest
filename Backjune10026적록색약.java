package 탐색;
import java.util.*;
import java.io.*;

public class Backjune10026적록색약 {
    static int[][] draw;
    static int node;
    static boolean[][] visited;
    static int normal_answer;
    static int abnormal_answer;

    public static void dfs(int i, int j) {
        visited[i][j] = true;
        int color = draw[i][j];

        // 상하좌우로 이동하면서 같은 색상을 가진 노드를 탐색
        if (i + 1 < node && !visited[i + 1][j] && draw[i + 1][j] == color) dfs(i + 1, j);
        if (i - 1 >= 0 && !visited[i - 1][j] && draw[i - 1][j] == color) dfs(i - 1, j);
        if (j + 1 < node && !visited[i][j + 1] && draw[i][j + 1] == color) dfs(i, j + 1);
        if (j - 1 >= 0 && !visited[i][j - 1] && draw[i][j - 1] == color) dfs(i, j - 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        node = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        normal_answer = 0;
        abnormal_answer = 0;
        draw = new int[node][node];
        visited = new boolean[node][node];

        // 입력받은 형태로 배열 초기화
        for (int i = 0; i < node; i++) {
            String input = bf.readLine();
            for (int j = 0; j < node; j++) {
                char ch = input.charAt(j);
                switch (ch) {
                    case 'R':
                        draw[i][j] = 0;
                        break;
                    case 'G':
                        draw[i][j] = 1;
                        break;
                    case 'B':
                        draw[i][j] = 2;
                        break;
                }
            }
        }

        // 일반인 경우 영역 구하기
        for (int i = 0; i < node; i++) {
            for (int j = 0; j < node; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    normal_answer++;
                }
            }
        }

        // 적록색맹 경우 영역 구하기
        visited = new boolean[node][node]; // 방문 배열 초기화
        for (int i = 0; i < node; i++) {
            for (int j = 0; j < node; j++) {
                if (draw[i][j] == 1) draw[i][j] = 0; // G를 R로 변환
            }
        }

        for (int i = 0; i < node; i++) {
            for (int j = 0; j < node; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    abnormal_answer++;
                }
            }
        }

        System.out.println(normal_answer + " " + abnormal_answer);
    }
}
