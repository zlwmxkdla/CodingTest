import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 1;
        int right = distance;
        Arrays.sort(rocks);
        while(left<=right){
            int mid = (left+right)/2;
            
            if(getRemoveRockCnt(rocks,mid,distance)<=n){
                answer = mid;
                left = mid+1;
            }else{
                right = mid - 1;
            }
            
        }
        return answer;
    }
    
    public int getRemoveRockCnt(int[]rocks, int mid, int distance){
        //mid가 지점 간 최소 거리가 되어야 함
        //그렇게 하기 위해 제거해야 할 바위의 개수 리턴
        int before = 0;
        int end = distance;
        int removeCnt = 0;
        for(int i=0;i<rocks.length;i++){
            if(rocks[i]-before<mid){
                removeCnt+=1;
                continue;
            }
            before = rocks[i];
        }
        if(end-before<mid)removeCnt+=1;
        return removeCnt;
    }
}
