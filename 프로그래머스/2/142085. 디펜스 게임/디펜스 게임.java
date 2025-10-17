import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);   // 이번 라운드 적 수 추가
            n -= enemy[i];      // 병사로 일단 막음
            
            if (n < 0) {        // 병사 부족 시
                if (k > 0) {    // 무적권이 남아있다면
                    n += pq.poll();  // 지금까지 중 가장 큰 wave를 무적 처리
                    k--;
                } else {
                    return i;   // 더 이상 막을 수 없음
                }
            }
        }
        
        return enemy.length;  // 모든 라운드 통과
    }
}
