import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        List<Integer> list = new ArrayList<>();
        for(Integer e:B)list.add(e);
        
        Collections.sort(list);
        for(int i=0;i<A.length;i++){
            int now = A[i];
            for(int j=0;j<list.size();j++){
                if(list.get(j)>now){
                    answer+=1;
                    list.remove(j);
                    break;
                }
            }
        }
        return answer;
    }
}