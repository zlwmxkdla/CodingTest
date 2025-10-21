import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int shootx = -1;
        Arrays.sort(targets, (a,b)->(a[1]-b[1]));
        for(int i=0;i<targets.length;i++){
            int s = targets[i][0];
            int e = targets[i][1];
            
            if(s<shootx)continue;
            else{
                answer+=1;
                shootx=e;
            }
        }
        return answer;
    }
}