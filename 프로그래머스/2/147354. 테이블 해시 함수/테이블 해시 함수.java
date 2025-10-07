import java.util.*;
class Solution {
    public static class node implements Comparable<node>{
        int[] d;
        int v;
        public node(int[] d, int v){
            this.d=d;
            this.v=v;
        }
        @Override
        public int compareTo(node b){
            if(this.v!=b.v)return this.v-b.v;
            return b.d[0]-this.d[0];
        }
    }
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int n = data.length;
        int m = data[0].length;
        List<node> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new node(data[i],data[i][col-1]));
        }
        Collections.sort(list);
        List<Integer> ans = new ArrayList<>();
        for(int i=row_begin;i<=row_end;i++){
            int sum=0;
            
            int[] d = list.get(i-1).d;
            for(int j=0;j<m;j++)sum+=(d[j]%i);
            ans.add(sum);
        }
        for(Integer e:ans)answer=answer^e;
        return answer;
    }
}