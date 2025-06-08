import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();  // 최댓값으로 초기화

        // 1단위부터 문자열 길이 절반까지
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, unit); // 첫 단위
            int count = 1;

            // 단위만큼 비교하며 반복
            for (int j = unit; j <= s.length(); j += unit) {
                String curr;
                if (j + unit <= s.length()) {
                    curr = s.substring(j, j + unit);
                } else {
                    curr = s.substring(j);
                }

                if (prev.equals(curr)) {
                    count++;
                } else {
                    // 압축 문자열 붙이기
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(prev);
                    prev = curr;
                    count = 1;
                }
            }

            // 마지막 단위 처리
            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);

            // 최소 길이 업데이트
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}
