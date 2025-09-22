import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        // 무게별 빈도수를 저장할 맵
        Map<Double, Integer> map = new HashMap<>();
        for (int w : weights) {
            map.put((double) w, map.getOrDefault((double) w, 0) + 1);
        }

        // 맵의 키(고유한 무게)들을 순회
        for (Double w : map.keySet()) {
            long count = map.get(w);

            // 1. 같은 무게끼리 짝을 이루는 경우
            if (count > 1) {
                answer += (count * (count - 1)) / 2;
            }

            // 2. 다른 무게와 짝을 이루는 경우
            // w1 * d1 = w2 * d2 -> w2 = w1 * (d1/d2)
            // 4/3, 3/2, 2 (4/2) 비율을 체크
            if (map.containsKey(w * 4.0 / 3.0)) {
                answer += count * map.get(w * 4.0 / 3.0);
            }
            if (map.containsKey(w * 3.0 / 2.0)) {
                answer += count * map.get(w * 3.0 / 2.0);
            }
            if (map.containsKey(w * 2.0)) {
                answer += count * map.get(w * 2.0);
            }
        }
        
        return answer;
    }
}