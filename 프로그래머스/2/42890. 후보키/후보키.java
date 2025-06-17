import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;
        List<Set<Integer>> candidateKeys = new ArrayList<>();

        // 1. 가능한 모든 컬럼 조합을 생성 (비트마스킹 사용)
        for (int i = 1; i < (1 << col); i++) {
            Set<String> tuples = new HashSet<>();

            for (int r = 0; r < row; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < col; c++) {
                    if ((i & (1 << c)) != 0) {
                        sb.append(relation[r][c]).append(",");
                    }
                }
                tuples.add(sb.toString());
            }

            // 2. 유일성 검사
            if (tuples.size() == row) {
                // 3. 최소성 검사
                boolean isMinimal = true;
                for (Set<Integer> key : candidateKeys) {
                    if ((i & toBitmask(key)) == toBitmask(key)) {
                        isMinimal = false;
                        break;
                    }
                }

                // 후보키로 등록
                if (isMinimal) {
                    candidateKeys.add(toSet(i, col));
                }
            }
        }

        return candidateKeys.size();
    }

    // 비트마스크를 Set으로 변환
    private Set<Integer> toSet(int bitmask, int col) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < col; i++) {
            if ((bitmask & (1 << i)) != 0) {
                set.add(i);
            }
        }
        return set;
    }

    // Set을 비트마스크로 변환
    private int toBitmask(Set<Integer> set) {
        int bitmask = 0;
        for (int i : set) {
            bitmask |= (1 << i);
        }
        return bitmask;
    }
}
