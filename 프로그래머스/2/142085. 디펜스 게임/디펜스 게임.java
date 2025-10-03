import java.util.*;

class Solution {
    /**
     * 디펜스 게임의 최대 라운드 수를 계산합니다.
     * 가장 많은 병사를 소모한 라운드에 무적권을 사용하는 그리디 전략을 사용합니다.
     * * @param n 준호가 가진 병사의 수
     * @param k 사용 가능한 무적권의 수
     * @param enemy 각 라운드의 적의 수
     * @return 준호가 막을 수 있는 최대 라운드 수
     */
    public int solution(int n, int k, int[] enemy) {
        // 병사 소모량이 큰 라운드를 저장할 PriorityQueue (Max-Heap)
        // 무적권을 사용했을 때 가장 큰 이득(많은 병사 회복)을 얻기 위함
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long currentN = n; // 병사 n이 최대 10억이므로 long으로 안전하게 처리
        
        for (int round = 0; round < enemy.length; round++) {
            int currentEnemy = enemy[round];
            
            // 1. 현재 라운드를 병사로 막았다고 가정하고 소모량을 기록
            pq.offer(currentEnemy);
            currentN -= currentEnemy;
            
            // 2. 병사가 부족해졌다면 무적권을 사용해야 함 (currentN < 0)
            if (currentN < 0) {
                // 3. 무적권 횟수가 남아있는지 확인
                if (k > 0) {
                    // 무적권 사용: 지금까지 막은 라운드 중 병사 소모가 가장 컸던 라운드에 사용
                    int maxConsumed = pq.poll(); // 가장 큰 소모량 (Max-Heap의 root)
                    
                    // 병사를 돌려받음 (마치 그 라운드에 무적권을 쓴 것처럼)
                    currentN += maxConsumed;
                    k--; // 무적권 횟수 차감
                } else {
                    // 4. 무적권이 없으면 더 이상 진행 불가
                    // 현재 라운드(round)는 막지 못한 것이므로, 최대 라운드는 round입니다.
                    return round;
                }
            }
        }
        
        // 5. 모든 라운드를 막아냈다면, 적 배열의 길이(enemy.length)가 최대 라운드 수
        return enemy.length;
    }
}