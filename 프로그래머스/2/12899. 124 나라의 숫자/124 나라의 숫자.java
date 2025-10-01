import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        
        // 124나라의 숫자는 3진법과 유사하지만, 0 대신 4가 쓰이는 비표준 3진법입니다.
        // n이 0보다 클 때까지 반복합니다.
        while(n > 0){ 
            int remainder = n % 3;
            
            if(remainder == 1) {
                answer = "1" + answer;
                n = n / 3;
            } else if(remainder == 2) {
                answer = "2" + answer;
                n = n / 3;
            } else { // remainder == 0 일 때 (가장 중요)
                answer = "4" + answer;
                // 나머지가 0일 때, 다음 몫을 계산하기 위해 n에서 1을 빼줍니다.
                // (n-1)/3을 통해 몫을 계산합니다.
                n = (n / 3) - 1; 
                // 또는 n = (n-1) / 3; 과 같이 처리해도 됩니다.
            }
        }
        
        return answer;
    }
}