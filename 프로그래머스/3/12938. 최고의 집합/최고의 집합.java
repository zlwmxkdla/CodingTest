import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        
        if(n>s)return new int[]{-1};
        int[] answer = new int[n];
        Arrays.fill(answer,s/n);
        int divid = s%n;
        int cnt =0;
        for(int i=n-1;i>=0;i--){
            if(cnt>=divid)break;
            answer[i]+=1;
            cnt+=1;
        }
        return answer;
    }
}