import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<times.length;i++)temp.add(diffs[i]);
        Collections.sort(temp);
        long end = temp.get(temp.size()-1);
        long start = temp.get(0);
        
        
        long minlevel = end;
        while(start<=end){
            long time = 0;
            long mid = (start+end)/2;//숙련도
            for(int i=0;i<diffs.length;i++){
                if(diffs[i]<=mid)time+=times[i];//퍼즐을 틀리지 않고 해결
                else{
                    time+=(diffs[i]-mid)*(times[i]+times[i-1]);//퍼즐 틀린 후 이전 퍼즐 풀고 오기
                    time+=times[i];//현재 퍼즐 해결
                }
            }
            if(time>limit)start=mid+1;
            else{
                end=mid-1;
                minlevel=Math.min(minlevel,mid);
            }
        }
        return (int)minlevel;
    }
}