import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] array = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                array[i][j]=board[i].charAt(j);
            }
        }
        while(true){
            //제거할 위치 저장해 놓기
            Set<String> remove = new HashSet<>();
            for(int i=0;i<m-1;i++){//제거가 가능한 블록 탐색
                for(int j=1;j<n-1;j++){
                    char now = array[i][j];
                    if(now!='a'){
                        if(array[i][j-1]==array[i+1][j-1]&&array[i+1][j-1]==array[i+1][j]&&array[i+1][j]==now){//왼쪽으로 사각형 생김
                            remove.add(i+","+j);
                            remove.add(i+","+(j-1));
                            remove.add((i+1)+","+(j-1));
                            remove.add((i+1)+","+j);
                        }
                        if(array[i][j+1]==array[i+1][j+1]&&array[i+1][j+1]==array[i+1][j]&&array[i+1][j]==now){//오른쪽으로 사각형 생김
                            remove.add(i+","+j);
                            remove.add(i+","+(j+1));
                            remove.add((i+1)+","+(j+1));
                            remove.add((i+1)+","+j);
                        }
                    }
                    
                }
            }
            if(remove.size()==0){
                //삭제할 블록이 없는 경우 게임 종료
                break;
            }
            answer+=remove.size(); //삭제된 블록의 개수 추가
            for(String pos:remove){
                String[] parts = pos.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                array[x][y] = 'a'; //블록 삭제하기
            }
            
            //블록 삭제되고 난 후 나머지 블록들 이동시키기
            for (int j = 0; j < n; j++) { // 열 반복
                for (int i = m - 1; i >= 0; i--) { // 아래에서 위로 올라감
                    if (array[i][j] == 'a') { // 빈 칸이면
                        // 그 위에서 블록을 찾음
                        for (int k = i - 1; k >= 0; k--) {
                            if (array[k][j] != 'a') {
                                array[i][j] = array[k][j];  // 아래로 끌어내림
                                array[k][j] = 'a';          // 끌어낸 자리는 빈 칸으로
                                break;                      // 하나만 당기고 다음 줄로
                            }
                        }
                    }
                }
            }

            
        }
        return answer;
    }
}