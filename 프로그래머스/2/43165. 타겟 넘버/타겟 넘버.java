class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0,0,target,numbers);
        return answer;
    }
    public void dfs(int start, int sum, int target, int[]numbers){
        if(start==numbers.length){
            if(sum==target)answer+=1;
            
            return;
        }
        dfs(start+1,sum+numbers[start],target,numbers);
        dfs(start+1,sum-numbers[start],target,numbers);
    }
}