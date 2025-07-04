import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int play_time_sec = toSec(play_time);
        int adv_time_sec = toSec(adv_time);
        long[] viewers = new long[play_time_sec+1];
        
        for(int i=0;i<logs.length;i++){
            String[] log = logs[i].split("-");
            int from = toSec(log[0]);
            int to = toSec(log[1]);
            viewers[from]+=1;
            viewers[to]-=1;
        }
        //시각 별 시청자 수 저장하기
        for(int i=1;i<viewers.length;i++){
            viewers[i]+=viewers[i-1];
        }
        //시각 별 누적 시청 시간 저장하기 viewsum[i] 는 0초부터 i초까지의 누적 시간
        long[] viewsum = new long[play_time_sec+1];
        viewsum[0]=viewers[0];
        for(int i=1;i<viewsum.length;i++){
            viewsum[i]=viewsum[i-1]+viewers[i];
        }
        //슬라이딩 윈도우
        long max = 0;
        int best = 0;
        for(int start=0;start+adv_time_sec<=play_time_sec;start++){
            int end = start+adv_time_sec-1;
            long total = viewsum[end]-(start>0?viewsum[start-1]:0);
            if(total>max){
                max = total;
                best = start;
            }
        }
        return toStr(best);
    }
    public int toSec(String time){
        String[]times = time.split(":");
        int sec = 0;
        sec += (Integer.parseInt(times[0])*3600);
        sec += (Integer.parseInt(times[1])*60);
        sec += Integer.parseInt(times[2]);
        return sec;
    }
    public String toStr(int num){
        int hour = num/3600;
        num%=3600;
        int min = num/60;
        num%=60;
        int sec = num;
        return String.format("%02d:%02d:%02d",hour,min,sec);
    }
}