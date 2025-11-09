import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        long start = 1;
        long maxn=(long)n;
        for(Integer e: stations){
            long left = (long)e-w;
            long gap = left-start;
            if(gap>0)answer+=(int)((gap+(2L*w+1)-1)/(2L*w+1));
            start = (long)e + w+ 1;
          
        }
        if(start<=maxn)answer+=(int)(((n-start+1)+(2L*w+1)-1)/(2L*w+1));


        return answer;
    }
}