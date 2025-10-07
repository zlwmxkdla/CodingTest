import java.util.*;
class Solution {
    //스택으로 해결해야 할 거 같음
    // 이 문제는 연산자의 순서, 숫자의 순서가 고정되어 있음. 어디서부터 시작할지를 결정하는 것이 핵심임
    public long solution(String expression) {
        long answer = 0;
        List<String> exp = new ArrayList<>();
        
        
        int start = 0;
        for(int i=0;i<expression.length();i++){
            char op = expression.charAt(i);
            if(op=='+'){
                String num = expression.substring(start,i);
                start=i+1;
                exp.add(num);
                exp.add(String.valueOf(op));
            }else if(op=='-'){
                String num = expression.substring(start,i);
                start=i+1;
                exp.add(num);
                exp.add(String.valueOf(op));
            }else if(op=='*'){
                String num = expression.substring(start,i);
                start=i+1;
                exp.add(num);
                exp.add(String.valueOf(op));
            }
            if(i==expression.length()-1){
                String num = expression.substring(start,i+1);
                exp.add(num);
            }
        }
        
        char[][]couples = {{'-','+','*'},{'-','*','+'},{'+','-','*'},{'+','*','-'},{'*','-','+'},{'*','+','-'}};
        
        
        for(int k=0;k<6;k++){
            Stack<String> stack = new Stack<>();
            List<String> temp = new ArrayList<>(exp);
            for(int t=0;t<3;t++){
                stack = new Stack<>();
                char nowop = couples[k][t];
                for(int i=0;i<temp.size();i++){
                    String nowv=temp.get(i);
                    //한자리수 숫자
                    if(nowv.length()==1&&(nowv.charAt(0)!=couples[k][0]&&nowv.charAt(0)!=couples[k][1]&&nowv.charAt(0)!=couples[k][2]))stack.push(nowv);
                    else if(nowv.length()>1)stack.push(nowv);//두자리 이상 숫자   
                    else{
                        if(nowv.charAt(0)==nowop){
                            if(!stack.isEmpty()){
                                long before = Long.parseLong(stack.pop());
                                long next = Long.parseLong(temp.get(i+1));
                                long after = getvalue(before,next,nowop);
                           
                                stack.push(String.valueOf(after));
                                i+=1;
                            }
                            
                        }else {
                            stack.push(nowv);
                        }
                    }
                }
                if(stack.size()>1){
                    List<String> tt = new ArrayList<>();
                    while(!stack.isEmpty())tt.add(stack.pop());
                    temp = new ArrayList<>();
                    for(int j=tt.size()-1;j>=0;j--)temp.add(tt.get(j));
                }else answer = Math.max(Math.abs(Long.parseLong(stack.pop())),answer);
            }
            
        }    
        
        
        
        
        return answer;
    }
    public static long getvalue(long x,long y, char c){
        long v=0;
        switch(c){
            case '+':
                v= x+y;
                break;
            case '-':
                v= x-y;
                break;
            case '*':
                v= x*y;
                break;
        }
        return v;
    }
}