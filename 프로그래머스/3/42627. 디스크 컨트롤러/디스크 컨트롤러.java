import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        // 1) 도착 리스트: 요청시점 기준 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        // 2) 준비 큐: 소요시간 기준
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        int time = 0;       // 현재 시각
        int idx = 0;        // 도착 리스트 인덱스
        int sum = 0;        // 총 턴어라운드 타임
        
        // 3) 모든 작업이 처리될 때까지
        while (idx < n || !pq.isEmpty()) {
            // 3-1) 도착한 작업 전부 준비 큐에 넣기
            while (idx < n && jobs[idx][0] <= time) {
                pq.offer(jobs[idx]);
                idx++;
            }
            
            // 3-2) 실행할 작업이 없으면, 다음 도착 시점으로 점프
            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            
            // 3-3) 소요시간 짧은 순으로 작업 수행
            int[] job = pq.poll();
            time += job[1];
            sum += time - job[0];
        }
        
        return sum / n;
    }
}
