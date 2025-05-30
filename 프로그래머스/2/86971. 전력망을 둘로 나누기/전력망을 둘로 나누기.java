import java.util.*;
class Solution {
    static List<List<Integer>> list;
    boolean[]visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        list = new LinkedList<>();
        for(int i=0;i<=n;i++)list.add(new LinkedList<>());//리스트에는 1번부터 저장되어야 함
        //연결 관계 저장해 놓기
        for(int i=0;i<wires.length;i++){
            int from = wires[i][0];
            int to = wires[i][1];
            list.get(from).add(to);
            list.get(to).add(from);
        }
        
        for(int i=0;i<wires.length;i++){//모든 경우에 대하여 제거한 후 값 구하기
            //현재 제거할 관계
            int from = wires[i][0];
            int to = wires[i][1];
            list.get(from).remove(Integer.valueOf(to));
            list.get(to).remove(Integer.valueOf(from));
            //현재의 경우에서 차이 구하기
            visited= new boolean[n+1];
            for(int j=1;j<=n;j++){//모든 노드에 대해서 탐색
                if(!visited[j]){
                    dfs(j);
                    break;
                }
            }
            int sub1 = 0;
            for(int j=1;j<=n;j++){
                if(visited[j])sub1+=1;
            }
            int sub2 = n-sub1;
            answer = Math.min(answer,Math.abs(sub1-sub2));
            //제거했던 관계들 다시 연결해 놓기
            list.get(from).add(to);
            list.get(to).add(from);
        }
        
        return answer;
    }
    public void dfs(int now){
        for(Integer e:list.get(now)){
            if(!visited[e]){
                visited[e]=true;
                dfs(e);
            }
        }
    }
}