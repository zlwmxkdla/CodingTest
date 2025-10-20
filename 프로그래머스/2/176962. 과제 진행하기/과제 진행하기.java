import java.util.*;

class Solution {
    // 과제 정보를 담을 클래스
    public static class Task {
        String name;
        int startTime; // 시작 시각 (분 단위)
        int playTime;  // 총 필요 시간 (분 단위)
        
        // 남은 시간(leftTime)을 별도로 관리하는 대신, playTime 자체를 남은 시간처럼 사용하고
        // 필요에 따라 playTime을 업데이트하여 관리할 수 있습니다.
        public Task(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }
    }
    
    // "HH:MM" 형태의 문자열을 분 단위 정수로 변환하는 유틸리티 메서드
    public static int toMin(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    public String[] solution(String[][] plans) {
        // 1. 과제 정보 파싱 및 정렬
        // String[][] plans를 Task 객체 배열로 변환
        Task[] tasks = new Task[plans.length];
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int startTime = toMin(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            tasks[i] = new Task(name, startTime, playTime);
        }
        
        // 시작 시간을 기준으로 오름차순 정렬 (HH:MM 문자열 정렬 로직과 동일)
        Arrays.sort(tasks, (a, b) -> a.startTime - b.startTime);
        
        // 2. 시뮬레이션을 위한 변수 준비
        List<String> answer = new ArrayList<>();
        // 일시 정지된 과제를 담을 스택 (가장 최근에 멈춘 과제부터 재개)
        Stack<Task> stoppedTasks = new Stack<>();
        
        // 현재 시간 (가장 첫 번째 과제의 시작 시간으로 초기화)
        int currentTime = tasks[0].startTime;
        
        // 3. 메인 시뮬레이션 루프 (새로운 과제 처리)
        // 마지막 과제는 루프에서 별도로 처리하거나, 루프 내에서 처리 후 마지막에 스택 처리
        for (int i = 0; i < tasks.length; i++) {
            Task currentTask = tasks[i];
            
            // 현재 작업의 시작 시간이 currentTime보다 크면, 그 시간 차이만큼
            // 스택에 멈춰있던 과제를 재개할 수 있는 여유 시간이 생긴다.
            int availableTime = currentTask.startTime - currentTime;
            
            // 멈춰있는 과제가 있고, 여유 시간이 있다면
            while (availableTime > 0 && !stoppedTasks.isEmpty()) {
                Task stoppedTask = stoppedTasks.pop();
                
                // 멈춘 과제를 완료할 수 있는 경우
                if (availableTime >= stoppedTask.playTime) {
                    answer.add(stoppedTask.name); // 완료 목록에 추가
                    availableTime -= stoppedTask.playTime; // 여유 시간 감소
                    currentTime += stoppedTask.playTime; // 현재 시간 증가
                } 
                // 멈춘 과제를 완료할 수 없는 경우 (시간이 부족함)
                else {
                    stoppedTask.playTime -= availableTime; // 남은 시간 갱신
                    stoppedTasks.push(stoppedTask); // 다시 스택에 넣고
                    currentTime += availableTime; // 현재 시간 증가 (다음 과제 시작 시간까지)
                    availableTime = 0; // 여유 시간 소진
                }
            }
            
            // 멈춰있던 과제를 처리했거나, 여유 시간이 없어진 후, 
            // 현재 순서의 과제를 시작한다.
            // 멈춘 과제 스택에 현재 과제를 넣는 것으로 시뮬레이션 시작
            stoppedTasks.push(currentTask);
            // 현재 시간을 다음 과제의 시작 시간으로 업데이트
            currentTime = currentTask.startTime;
        }

        // 4. 스케줄된 모든 과제를 시작한 후, 스택에 남아있는 과제 처리 (가장 최근 과제부터 완료)
        while (!stoppedTasks.isEmpty()) {
            answer.add(stoppedTasks.pop().name);
        }

        // 5. 결과 반환
        return answer.toArray(new String[0]);
    }
}