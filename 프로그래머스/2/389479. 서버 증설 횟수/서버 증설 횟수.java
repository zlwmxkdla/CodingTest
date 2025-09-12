class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[players.length];//증설된 서버 개수들
        int[] addNum = new int[players.length]; //각 시점에 증설 횟수
        
        for(int i=0;i<players.length;i++){
            if(players[i]>=m){
                int needServers = players[i]/m; //이용하기 위한 서버 개수
                int toAddServers = needServers-servers[i]; //추가해야 하는 서버 개수
                if(toAddServers>0){
                    addNum[i]=toAddServers;
                    //서버 증설해 놓기
                    for(int j=i;j<i+k;j++){
                        if(j>=players.length)break;
                        servers[j]+=toAddServers;
                    }
                }
            }
        }
        
        for(int i=0;i<addNum.length;i++)answer+=addNum[i];
        return answer;
    }
}