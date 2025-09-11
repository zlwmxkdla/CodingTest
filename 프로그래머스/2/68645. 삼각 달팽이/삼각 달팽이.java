import java.util.*;
class Solution {
    public int[] solution(int n) {
       int N = n;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0});
        for(int i=1;i<=n;i++){
            int[] l = new int[i];
            list.add(l);
        }
        
        
        int value = 1;
        int startRow = 1;
        int endRow = n;
        int startCol=0;
        int endCol = 0;
        while(N>0){
            //하강
            for(int i=startRow;i<=endRow;i++){
                list.get(i)[startCol] =value;
                value+=1;
            }
            
            
            
            N-=1;
            //오른쪽으로
            for(int i=startCol+1;i<N+startCol+1;i++){
                list.get(endRow)[i]=value;
                value+=1;
            }
            N-=1;
            endRow-=1;
            startRow+=1;
            //위쪽으로
            for(int i=endRow;i>=startRow;i--){
                list.get(i)[i-1-endCol]=value;
                value+=1;
            }
            N-=1;
            startCol+=1;
            startRow+=1;
            endCol+=1;
        }
        
        int cnt = n*(n+1)/2;
        int []answer = new int[cnt];
        int index = 0;
        for(int i=1;i<list.size();i++){
            for(int j=0;j<list.get(i).length;j++){
                    answer[index++]=list.get(i)[j];
            }
        }
        
        return answer;
    }
}