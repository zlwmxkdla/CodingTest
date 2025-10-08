import java.util.*;
class Solution {
    static List<int[]> moves = new ArrayList<>();
    public int[][] solution(int n) {
        
        // 1번 기둥에서 3번 기둥으로 n개의 원판을 , 2번 기둥을 보조로 사용하여 이동시키기
        hanoi(n,1,3,2);
        int[][]answer = new int[moves.size()][2];
        for(int i=0;i<moves.size();i++)answer[i]=moves.get(i);
        return answer;
    }
    public static void hanoi(int n,int from,int to, int help){
        if(n==1){
            moves.add(new int[]{from,to});
            return;
        }
        hanoi(n-1,from,help,to);
        moves.add(new int[]{from,to});
        hanoi(n-1,help,to,from);
    }
}