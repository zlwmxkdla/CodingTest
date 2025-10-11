import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i=0;i<=d;i++){
            int j=i*k;
            if(Math.pow(d,2)<Math.pow(j,2))break;
            int n = (int)Math.sqrt(Math.pow(d,2)-Math.pow(j,2));
 
            answer+=(n/k+1);
        }
        return answer;
    }
}