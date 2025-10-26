import java.util.*;

class Solution {
    // 특정 플레이어(player: 'O' 또는 'X')가 승리했는지 확인
    public static boolean checkWin(String[] board, char player) {
        // 1. 가로 3줄 검사
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) {
                return true;
            }
        }
        // 2. 세로 3줄 검사
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == player && board[1].charAt(j) == player && board[2].charAt(j) == player) {
                return true;
            }
        }
        // 3. 두 대각선 검사
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            return true;
        }
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) {
            return true;
        }
        return false;
    }

    public int solution(String[] board) {
        int cntO = 0;
        int cntX = 0;

        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'O') cntO++;
                else if (c == 'X') cntX++;
            }
        }

        boolean oWin = checkWin(board, 'O');
        boolean xWin = checkWin(board, 'X');

        // 1. 말의 개수 기본 규칙 검사: O는 X와 같거나 1개 많아야 한다. (O가 선공이므로)
        if (cntO < cntX || cntO > cntX + 1) {
            return 0; // 불가능한 상태
        }
        
        // 2. O가 이겼을 때의 규칙 검사
        // O가 이겼다면, X는 더 이상 말을 놓을 수 없으므로 O가 반드시 1개 더 많아야 한다. (O의 턴에 게임 종료)
        if (oWin) {
            if (cntO == cntX) {
                return 0; // O가 이겼는데 말의 개수가 같으면 (X가 마지막에 둔 셈) -> 불가능
            }
            if (xWin) {
                return 0; // O와 X가 동시에 이기는 것은 불가능
            }
        }
        
        // 3. X가 이겼을 때의 규칙 검사
        // X가 이겼다면, O와 X의 말의 개수는 같아야 한다. (X의 턴에 게임 종료)
        if (xWin) {
            if (cntO > cntX) {
                return 0; // X가 이겼는데 O가 더 많으면 -> 불가능
            }
        }

        // 4. 위의 모든 규칙을 통과했다면 가능한 상태
        return 1;
    }
}