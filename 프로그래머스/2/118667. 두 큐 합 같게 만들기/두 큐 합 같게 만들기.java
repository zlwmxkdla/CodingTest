class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long q1sum=0,q2sum=0;
        for(int i=0;i<queue1.length;i++){
            q1sum+=queue1[i];
            q2sum+=queue2[i];
        }
        if((q1sum+q2sum)%2==1)return -1;
        long goal = (q1sum+q2sum)/2;
        int n = queue1.length;
        int m = queue2.length;
        
        int []total = new int[2*(n+m)];
        
        for(int i=0;i<n;i++)total[i]=queue1[i];
        int index = 0;
        for(int i=n;i<n+m;i++)total[i]=queue2[index++];
        for(int i=n+m;i<total.length;i++)total[i]=total[i-(n+m)];
        
        
        
        int start = 0;
        int end = n-1;
        while(true){
            if(start==2*(n+m)-1||end==2*(n+m)-1){
                answer=-1;
                break;
            }
            if(q1sum<goal){
                end=(end+1)%total.length;
                answer+=1;
                q2sum-=total[end];
                q1sum+=total[end];
            }else if(q1sum>goal){
                answer+=1;
                q1sum-=total[start];
                q2sum+=total[start];
                start+=1;
            }else break;
            
        }
        
        return answer;
    }
}