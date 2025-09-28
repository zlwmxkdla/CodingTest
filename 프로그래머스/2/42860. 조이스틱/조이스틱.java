class Solution {
    public int solution(String name) {
        int answer = 0;
    int n = name.length();
    
    // 1. 상하 이동 횟수 계산 (Vertical Moves)
    for (int i = 0; i < n; i++) {
        char c = name.charAt(i);
        // A와 Z 중 더 가까운 쪽의 이동 횟수를 더함
        answer += Math.min(c - 'A', 'Z' - c + 1); 
    }
    
    // 2. 최소 좌우 이동 횟수 계산 (Horizontal Moves)
    int min_move = n - 1; // 초기값: 오른쪽으로 쭉 가는 경우 (N-1)
    
    // 0번 인덱스부터 시작해서 모든 지점 i를 '오른쪽 이동의 끝'으로 가정
    for (int i = 0; i < n; i++) {
        
        // i 이후의 연속된 'A'가 끝나는 지점 j를 찾음
        int next_non_A = i + 1;
        while (next_non_A < n && name.charAt(next_non_A) == 'A') {
            next_non_A++;
        }
        
        // Case 1: 오른쪽으로 i만큼 갔다가 (i), 다시 돌아와 (i),
        //         남은 뒷부분을 왼쪽으로 처리 (n - next_non_A)
        int move_back = i * 2 + (n - next_non_A);
        
        // Case 2: 왼쪽으로 먼저 갔다가 (n - next_non_A), 다시 돌아와 (n - next_non_A),
        //         앞부분을 오른쪽으로 처리 (i)
        int move_forward = (n - next_non_A) * 2 + i;
        
        // 현재 i 지점을 기준으로 최소 경로 업데이트
        min_move = Math.min(min_move, move_back);
        min_move = Math.min(min_move, move_forward);
    }
    
    answer += min_move;
    return answer;
    }
    
}