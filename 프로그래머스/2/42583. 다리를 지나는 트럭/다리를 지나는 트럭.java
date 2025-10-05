import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> wait = new LinkedList<>();
        for(Integer e : truck_weights)wait.add(e);
        for(int i=0;i<bridge_length;i++)bridge.add(0);
        int sum=0;
        while(true){
            if(bridge.isEmpty()&&wait.isEmpty())break;
            sum-=bridge.poll();//빼고
            
            if(!wait.isEmpty()){//넣고
                
                if(sum+wait.peek()<=weight){
                    int newtruck=wait.poll();
                    sum+=newtruck;
                    bridge.add(newtruck);
                }else bridge.add(0);
            }
            
            answer+=1;
        }
        return answer;
    }
}