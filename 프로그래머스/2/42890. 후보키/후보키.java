import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int colsize = relation[0].length;
        List<Set<Integer>> candidates = new ArrayList<>();
  
        //1개부터 n개까지의 조합 만들기
        for(int size=1;size<=colsize;size++){
            List<Set<Integer>> combinations = new ArrayList<>();
            combinations = generateCombinations(colsize,size);
            for(Set<Integer> comb:combinations){
                if(checkUnique(comb,relation)&&checkMin(comb,candidates)){
                    candidates.add(comb);
                }
            }
        }
        
        return candidates.size();
    }
    private boolean checkUnique(Set<Integer> cand, String[][]relation){
        int len = relation.length;
        Set<String> rowSet = new HashSet<>();
        for(String[] row:relation){
            StringBuilder sb = new StringBuilder();
            for(int i:cand){
                sb.append(row[i]);
            }
            rowSet.add(sb.toString());
        }
        if(rowSet.size()==len)return true;
        return false;
    }
    
    private boolean checkMin(Set<Integer> cand, List<Set<Integer>> candidates){
        for(Set<Integer> key:candidates){
            if(cand.containsAll(key))return false;
            
        }
        return true;
    }
    private List<Set<Integer>> generateCombinations(int colsize,int size){
        List<Set<Integer>> result = new ArrayList<>();
        generateCombHelper(0,size,colsize,result,new HashSet<>());
        return result;
    }
    
    private void generateCombHelper(int start,int size,int colsize,List<Set<Integer>> result, Set<Integer> current){
        if(current.size()==size){
            result.add(new HashSet<>(current));
            return;
        }
        for(int i=start;i<colsize;i++){
            current.add(i);
            generateCombHelper(start+1,size,colsize,result,current);
            current.remove(i);
        }
    }
}