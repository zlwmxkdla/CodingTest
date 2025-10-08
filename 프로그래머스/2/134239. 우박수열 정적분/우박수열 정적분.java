import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        List<Integer> list = new ArrayList<>();
        list.add(k);
        while(true){
            if(k%2==0)k/=2;
            else{
                k*=3;
                k+=1;
            }
            list.add(k);
            if(k==1)break;
        }
        int n = list.size()-1;
        double[] sums = new double[n+1];
        for(int i=1;i<list.size();i++){
            int height = list.get(i);
            int bheight = list.get(i-1);
            double sum = (height+bheight)*0.5;
            sums[i]=sums[i-1]+sum;
        }
        double[] answer = new double[ranges.length];
        for(int i=0;i<ranges.length;i++){
            int from = ranges[i][0];
            int to = n+ranges[i][1];
            if(to<from)answer[i]=-1;
            else answer[i]=sums[to]-sums[from];
        }
        return answer;
    }
}