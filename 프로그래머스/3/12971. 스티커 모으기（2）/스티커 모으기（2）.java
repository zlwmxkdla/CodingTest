import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        if(sticker.length==0)return 0;
        if(sticker.length==1)return sticker[0];
        
        int[] dp = new int[sticker.length];
        int[] ndp = new int[sticker.length];
        
        dp[0]=sticker[0];
        dp[1]=dp[0];
        for(int i=2;i<dp.length-1;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+sticker[i]);
        }
        ndp[1]=sticker[1];
        for(int i=2;i<dp.length;i++){
            ndp[i]=Math.max(ndp[i-1],ndp[i-2]+sticker[i]);
        }
        answer = dp[dp.length-2]>ndp[ndp.length-1]?dp[dp.length-2]:ndp[ndp.length-1];

        return answer;
    }
}