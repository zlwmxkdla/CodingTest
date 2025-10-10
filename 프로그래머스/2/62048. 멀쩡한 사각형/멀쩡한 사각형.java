class Solution {
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long solution(int w, int h) {
        long W = (long) w;
        long H = (long) h;
        
        long commonDivisor = gcd(W, H);
        
        // 사용할 수 없는 사각형 개수
        long unusableSquares = W + H - commonDivisor; 
        
        // 전체 사각형 - 사용 불가 사각형
        return W * H - unusableSquares;
    }
}