class Solution {
    public int solution(String name) {
        int answer = 0;
        // 상하로 이동하는 횟수 구하기
        for(int i=0;i<name.length();i++){
            char now = name.charAt(i);
            if(now<=78)answer+=(now-65);
            else answer+=(91-now);
        }
        // 좌우로 이동하는 횟수 구하기
        // 정방향 이동하는 경우
        int right = 0;
        for(int i=name.length()-1;i>0;i--){
            if(name.charAt(i)!='A'){
                right=i;
                break;
            }
        }
        
        
        int left = 0;
        for(int i=0;i<name.length();i++){
            if(name.charAt(i)!='A'){
                left = name.length()-i;
                break;
            }
        }
        
        int both=Integer.MAX_VALUE;
        
        for(int end=0;end<name.length();end++){
            int cnt = 0;
            int rcnt=0;
            int nextA = name.length();
            for(int j=end+1;j<name.length();j++){
                if(name.charAt(j)!='A'){
                    nextA=j;
                    break;
                }
            }
            if(nextA==name.length()){
                both = Math.min(both,end*2);
                continue;
            }
            cnt+=(end*2);
            cnt+=(name.length()-nextA);
            rcnt+=((name.length()-nextA)*2);
            rcnt+=end;
            both = Math.min(both,Math.min(cnt,rcnt));
        }
        
        return answer+=Math.min(right,Math.min(left,both));
    }
}