class Solution {
    int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }

    void compress(int[][] arr, int x, int y, int size) {
        if (canZip(arr, x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }

        int half = size / 2;
        compress(arr, x, y, half);                   // 좌상
        compress(arr, x, y + half, half);            // 우상
        compress(arr, x + half, y, half);            // 좌하
        compress(arr, x + half, y + half, half);     // 우하
    }

    boolean canZip(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) return false;
            }
        }
        return true;
    }
}
