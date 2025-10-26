import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (a,b)->(a[1]-b[1]));
        int[] now = new int[]{targets[0][0],targets[0][1]};
        for(int i=1;i<targets.length;i++){
            if(targets[i][0]<now[1]){
                continue;
            }
            else{
                answer+=1;
                now[0]=targets[i][0];
                now[1]=targets[i][1];
            }
        }
        return answer;
    }
}