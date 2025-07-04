import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int colsize = relation[0].length;//열의 개수
        List<Set<Integer>> candidates = new ArrayList<>();
        
        //1~n 개의 길이의 조합 생성하기
        for(int size=1;size<=colsize;size++){
            List<Set<Integer>> combinations = generateCombinations(size,colsize);//만들어질 수 있는 후보키 조합들
            for(Set<Integer> comb:combinations){//각 조합에 대하여
                if(checkUnique(comb,relation)&&checkMin(comb,candidates)){//유일성과 최소성을 만족하는지 조사
                    candidates.add(comb);
                }
            }
        }
        return candidates.size();
    }
    private boolean checkUnique(Set<Integer> comb,String[][]relation){
        Set<String> tuples = new HashSet<>();
        int len = relation.length;
        for(int i=0;i<len;i++){
            StringBuilder sb = new StringBuilder();
            for(int e:comb){
                sb.append(relation[i][e]);
            }
            tuples.add(sb.toString());
        }
        if(tuples.size()==len)return true;
        return false;
    }
    private boolean checkMin(Set<Integer> comb, List<Set<Integer>> candidates){
        for(Set<Integer> s:candidates){
            if(comb.containsAll(s))return false;
        }
        return true;
    }
    private List<Set<Integer>> generateCombinations(int size, int colsize){
        List<Set<Integer>> combs = new ArrayList<>();
        generateCombhelper(0,size,combs,new HashSet<>(),colsize);
        return combs;
    }
    
    private void generateCombhelper(int start, int size, List<Set<Integer>>result,Set<Integer> set,int colsize){
        if(set.size()==size){
            result.add(new HashSet<>(set));
            return;
        }
        for(int i=start;i<colsize;i++){
            set.add(i);
            generateCombhelper(start+1,size,result,set,colsize);
            set.remove(i);
        }
    }
}