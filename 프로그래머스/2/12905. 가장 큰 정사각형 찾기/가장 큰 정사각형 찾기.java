class Solution {
    public int solution(int [][]board) {
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n][m];
        int ans = 0;

        // 첫 행과 첫 열은 그대로 복사
        for (int i = 0; i < n; i++) dp[i][0] = board[i][0];
        for (int j = 0; j < m; j++) dp[0][j] = board[0][j];

        // DP 점화식
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        // 1x1 정사각형만 있는 경우도 고려
        if (ans == 0) {
            for (int[] row : board)
                for (int v : row)
                    ans = Math.max(ans, v);
        }

        return ans * ans; // 정사각형 넓이
    }
}
