import java.util.Scanner;

public class Main {
    // 문자열이 팰린드롬인지 확인하는 함수
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // 팰린드롬이 될 때까지 문자열을 줄여가며 검사
        for (int i = 0; i < s.length(); i++) {
            // 현재 문자열이 팰린드롬이면 정답 계산
            if (isPalindrome(s.substring(i))) {
                int result = s.length() + i;
                System.out.println(result);
                return;
            }
        }

        // 만약 루프를 빠져나왔다면 전부 붙여야 함
        System.out.println(2 * s.length() - 1);
    }
}
