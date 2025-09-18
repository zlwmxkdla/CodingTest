import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0, total = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        for (int n : queue1) { q1.offer(n); sum1 += n; }
        for (int n : queue2) { q2.offer(n); sum2 += n; }
        total = sum1 + sum2;

        // 합이 홀수면 절대 같게 못 만듦
        if ((total & 1) == 1) return -1;
        long target = total / 2;

        int limit = (queue1.length + queue2.length) * 2; // 무한 루프 방지 상한
        int cnt = 0;

        while (sum1 != target) {
            if (cnt > limit) return -1;

            if (sum1 > target) {
                Integer val = q1.poll();
                if (val == null) return -1; // 방어 코드
                sum1 -= val;
                sum2 += val;
                q2.offer(val);
            } else {
                Integer val = q2.poll();
                if (val == null) return -1;
                sum2 -= val;
                sum1 += val;
                q1.offer(val);
            }
            cnt++;
        }
        return cnt;
    }
}
