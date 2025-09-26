import java.util.*;

class Solution {
    private List<List<Integer>> candidateKeys = new ArrayList<>();
    private int colCount;
    private String[][] relation;

    public int solution(String[][] relation) {
        this.relation = relation;
        this.colCount = relation[0].length;
        
        // 속성 조합을 크기 1부터 colCount까지 순서대로 탐색
        for (int size = 1; size <= colCount; size++) {
            boolean[] visited = new boolean[colCount];
            findCombinations(size, 0, new ArrayList<>(), visited);
        }
        
        return candidateKeys.size();
    }
    
    // 깊이 우선 탐색(DFS)으로 모든 속성 조합 생성
    private void findCombinations(int size, int start, List<Integer> currentCols, boolean[] visited) {
        if (currentCols.size() == size) {
            checkKey(currentCols);
            return;
        }
        
        for (int i = start; i < colCount; i++) {
            if (!visited[i]) {
                visited[i] = true;
                currentCols.add(i);
                findCombinations(size, i + 1, currentCols, visited);
                currentCols.remove(currentCols.size() - 1);
                visited[i] = false;
            }
        }
    }
    
    // 유일성과 최소성을 검사
    private void checkKey(List<Integer> cols) {
        // 1. 유일성 검사
        Set<String> uniqueTuples = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            StringBuilder key = new StringBuilder();
            for (Integer colIndex : cols) {
                key.append(relation[i][colIndex]).append(" ");
            }
            uniqueTuples.add(key.toString());
        }
        
        // 유일성 만족 여부 확인
        if (uniqueTuples.size() != relation.length) {
            return; // 유일하지 않으므로 후보키가 될 수 없음
        }
        
        // 2. 최소성 검사
        // 이전에 찾은 후보키들의 부분집합인지 확인
        if (isMinimal(cols)) {
            candidateKeys.add(new ArrayList<>(cols));
        }
    }
    
    // 최소성 조건을 만족하는지 최종 확인
    private boolean isMinimal(List<Integer> cols) {
        for (List<Integer> candidate : candidateKeys) {
            if (cols.containsAll(candidate)) {
                return false; // 현재 조합이 이미 찾은 후보키의 상위 집합이므로 최소성 위배
            }
        }
        return true; // 최소성 만족
    }
}