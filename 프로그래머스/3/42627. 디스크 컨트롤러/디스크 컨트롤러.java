import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs,(j1,j2)->(j1[0]-j2[0]));//작업이 요청되는 시점을 기준으로 정렬
        Queue<int[]> pq = new PriorityQueue<>((j1,j2)->(j1[1]-j2[1]));//작업이 소요되는 시간을 기준으로 정렬(대기 큐)
        
        int time = 0;
        int completedJobs = 0;
        int index = 0;
        int sum = 0;
        
        while(completedJobs<jobs.length){
            //모든 작업이 완료될 때까지
            //도착한 작업을 대기 큐에 넣기
            while(index<jobs.length&&jobs[index][0]<=time){
                pq.add(jobs[index]);
                index+=1;
            }
            //대기 큐에 작업이 없는 경우
            if(pq.isEmpty()){
                time = jobs[index][0];
                continue;
            }
            //대기 큐에 있는 작업들 수행하기
            int[] now = pq.poll();
            time+=now[1];
            sum+=(time-now[0]);
            completedJobs+=1;
        }
        return sum/jobs.length;
    }
}