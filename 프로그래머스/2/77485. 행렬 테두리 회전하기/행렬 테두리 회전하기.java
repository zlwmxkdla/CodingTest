import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int value = 1;
        int[][]grid=new int[rows+1][columns+1];
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                grid[i][j]=value++;
            }
        }
        
        for(int i=0;i<queries.length;i++){
            int x1=queries[i][0];
            int y1=queries[i][1];
            int x2=queries[i][2];
            int y2=queries[i][3];
            int min=rotate(x1,y1,x2,y2,grid);
            answer[i]=min;
            
        }
        return answer;
    }
    public int rotate(int x1,int y1, int x2,int y2,int[][]queries){
        int[]temp = new int[2*(x2-x1)+2*(y2-y1)];
        int index = 0;
        for(int i=y1;i<=y2;i++)temp[index++]=queries[x1][i];
        for(int i=x1+1;i<=x2;i++)temp[index++]=queries[i][y2];
        for(int i=y2-1;i>=y1;i--)temp[index++]=queries[x2][i];
        for(int i=x2-1;i>x1;i--)temp[index++]=queries[i][y1];
        
        index=0;
        for(int i=y1+1;i<=y2;i++)queries[x1][i]=temp[index++];
        for(int i=x1+1;i<=x2;i++)queries[i][y2]=temp[index++];
        for(int i=y2-1;i>=y1;i--)queries[x2][i]=temp[index++];
        for(int i=x2-1;i>=x1;i--)queries[i][y1]=temp[index++];
        Arrays.sort(temp);
        return temp[0];
    }
}