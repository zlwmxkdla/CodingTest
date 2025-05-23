public class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (right < sequence.length) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left++];
            }

            if (sum == k && (right - left) < minLength) {
                minLength = right - left;
                answer[0] = left;
                answer[1] = right;
            }

            right++;
        }

        return answer;
    }
}
