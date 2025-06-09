
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 자릿수
        int K = sc.nextInt(); // 제거할 개수
        String num = sc.next(); // 숫자 입력

        Deque<Character> stack = new ArrayDeque<>();
        int remove = K;

        for (int i = 0; i < N; i++) {
            char current = num.charAt(i);
            while (!stack.isEmpty() && remove > 0 && stack.peekLast() < current) {
                stack.pollLast(); // 뒤에서 제거
                remove--;
            }
            stack.offerLast(current);
        }

        // 남은 삭제 횟수만큼 뒤에서 제거
        while (remove-- > 0) {
            stack.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        System.out.println(sb.toString());
        sc.close();
    }
}
