import java.util.*;

class Solution {
    
    // 메인 로직을 담고 있는 메서드
    public int solution(int[] arrayA, int[] arrayB) {
        
        // 1. 각 배열의 최대공약수를 구한다.
        int gcdA = getGCD(arrayA);
        int gcdB = getGCD(arrayB);
        
        int resultA = 0; // arrayA의 GCD 조건을 만족하는 값
        int resultB = 0; // arrayB의 GCD 조건을 만족하는 값

        // 2. 조건 1 검사: gcdA가 arrayB의 어떤 원소도 나누지 않는지 확인
        if (checkCondition(gcdA, arrayB)) {
            resultA = gcdA;
        }

        // 3. 조건 2 검사: gcdB가 arrayA의 어떤 원소도 나누지 않는지 확인
        if (checkCondition(gcdB, arrayA)) {
            resultB = gcdB;
        }

        // 4. 두 조건 중 최댓값 반환
        int answer = Math.max(resultA, resultB);
        
        // 문제 조건: 조건을 만족하는 양의 정수가 없다면 0을 반환해야 합니다.
        // resultA 또는 resultB가 0 또는 1일 경우, 이는 문제에서 요구하는 답이 아님
        return answer;
    }

    /**
     * s가 targetArray의 어떤 원소도 나누지 않는지 확인하는 메서드
     * @param s 검사할 수 (GCD 후보)
     * @param targetArray s가 나누면 안 되는 배열
     * @return s가 targetArray의 모든 원소를 나누지 않으면 true, 하나라도 나누면 false
     */
    public static boolean checkCondition(int s, int[] targetArray) {
        // s가 1이면 모든 배열의 원소를 나누지 못하는 조건을 만족할 수 없으므로 제외 (0 반환을 위해)
        if (s == 1) return false; 
        
        for (int val : targetArray) {
            if (val % s == 0) { // 하나라도 나누어 떨어진다면 조건 불만족
                return false;
            }
        }
        return true; // 모든 원소를 나누지 않음
    }

    /**
     * 유클리드 호제법을 이용한 두 수의 최대공약수(GCD)
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * 배열의 모든 원소의 최대공약수(GCD)를 구하는 메서드
     */
    public static int getGCD(int[] arr) {
        if (arr == null || arr.length == 0) return 1;
        
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            // 최적화: GCD가 1이 되면 더 이상 계산할 필요가 없음
            if (result == 1) return 1; 
        }
        return result;
    }
}