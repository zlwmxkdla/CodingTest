class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int digit = storey % 10;         // 현재 자리
            int next  = (storey / 10) % 10;  // 윗자리(lookahead)

            if (digit > 5) {
                // 올림
                answer += (10 - digit);
                storey += 10; // 캐리 발생시켜 윗자리로 전달
            } else if (digit < 5) {
                // 내림
                answer += digit;
            } else { // digit == 5
                // 윗자리가 5 이상이면 올림, 아니면 내림
                if (next >= 5) {
                    answer += 5;
                    storey += 10; // 캐리
                } else {
                    answer += 5;  // 내림
                }
            }
            storey /= 10; // 다음 자리로 이동 (캐리 반영 후 나눗셈)
        }
        return answer;
    }
}
