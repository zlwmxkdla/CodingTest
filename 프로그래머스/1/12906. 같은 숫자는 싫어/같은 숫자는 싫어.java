import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> list = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1;i>=0;i--)stack.push(arr[i]);
        
        while(!stack.isEmpty()){
            int now = stack.pop();
            list.add(now);
            while(true){
                if(stack.isEmpty())break;
                int next = stack.pop();
                if(next!=now){
                    stack.push(next);
                    break;
                }
            }
        }

        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}