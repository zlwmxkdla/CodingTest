class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int playTime = toSeconds(play_time);
        int advTime = toSeconds(adv_time);
        
        //초마다 시청하는 사람들을 저장할 배열
        long[] viewers = new long[playTime+1];
        
        // 시청 중인 사람들 log들에 대하여 어느 지점에 사람이 있는지 저장
        for (String log : logs) {
            String[] p = log.split("-");
            int start = toSeconds(p[0]); //시작 시간
            int end = toSeconds(p[1]); //종료 시간
            viewers[start] += 1;
            viewers[end] -= 1;
        }
        
        // 시각 별 동시 시청자 수 계산하기
        for(int i=1;i<=playTime;i++){
            viewers[i]+=viewers[i-1];
        }
        
        // 구간 별 시청 시간의 합 계산
        long[] viewSum = new long[playTime + 1];
        viewSum[0] = viewers[0];
        for (int i = 1; i <= playTime; i++) {
            viewSum[i] = viewSum[i-1] + viewers[i];
        }
        
        // 최댓값 탐색 (슬라이딩 윈도우)
        long max = 0;
        int best = 0;
        for (int start = 0; start + advTime - 1 <= playTime; start++) {
            int end = start + advTime - 1;
            long total = viewSum[end] - (start > 0 ? viewSum[start-1] : 0);
            if (total > max) {
                max = total;
                best = start;
            }
        }
        
        return toHMS(best);
    }
    
        // 문자열 시간 -> 초 단
    private int toSeconds(String time) {
        String[] p = time.split(":");
        return Integer.parseInt(p[0]) * 3600
             + Integer.parseInt(p[1]) *   60
             + Integer.parseInt(p[2]);
    }

    // 반대 변환
    private String toHMS(int sec) {
        int hh = sec / 3600; sec %= 3600;
        int mm = sec /   60; sec %=   60;
        int ss = sec;
        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }

}