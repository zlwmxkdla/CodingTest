import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] time = new int[1440];
        for(int i=0;i<book_time.length;i++){
            String start[] = book_time[i][0].split(":");
            String end[] = book_time[i][1].split(":");
            int startTime = Integer.parseInt(start[0])*60+Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0])*60+Integer.parseInt(end[1]);
            for(int j=startTime;j<endTime+10;j++){
                if(j>=1440)break;
                time[j]+=1;
            }
        }
        Arrays.sort(time);
        answer = time[1439];
        return answer;
    }
}