class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            // 짝수면 무조건 x+1이 정답 (1비트만 다름)
            if (x % 2 == 0) {
                answer[i] = x + 1;
            } else {
                // 홀수일 경우
                // 1. x의 가장 오른쪽 0을 찾는다
                // 2. 그 자리를 1로 바꾸고 그 오른쪽 1을 0으로 바꿈
                long bit = 1;
                while ((x & bit) != 0) {
                    bit <<= 1;
                }
                answer[i] = x + bit - (bit >> 1);
            }
        }

        return answer;
    }
}
