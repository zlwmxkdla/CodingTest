import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer e:works)pq.add(e);
        for(int i=0;i<n;i++){
            int now= pq.poll();
            if(now==0)return 0;
            pq.add(now-1);
        }
        for(Integer e : pq){
            answer += (long)(e*e);
        }
        return answer;
    }
}