import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0, sum2 = 0;
        for (int n : queue1) {
            q1.add(n);
            sum1 += n;
        }
        for (int n : queue2) {
            q2.add(n);
            sum2 += n;
        }

        long total = sum1 + sum2;
        if (total % 2 == 1) return -1; // 합이 홀수면 불가능
        long target = total / 2;

        int maxOps = (queue1.length + queue2.length) * 2; // 무한루프 방지용
        int cnt = 0;

        while (cnt <= maxOps) {
            if (sum1 == target) return cnt;

            if (sum1 > target) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
            } else {
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.add(num);
            }
            cnt++;
        }

        return -1;
    }
}
