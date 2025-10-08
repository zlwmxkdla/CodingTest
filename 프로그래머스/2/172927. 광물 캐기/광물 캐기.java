import java.util.*;

class Solution {
    static class Node {
        int dia;
        int iron;
        int stone;
        public Node(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        List<Node> groups = new ArrayList<>();

        int totalPick = picks[0] + picks[1] + picks[2];
        int limit = Math.min(minerals.length, totalPick * 5); // ✅ 곡괭이 한도 내에서만

        // 1. 광물 5개씩 묶기
        for (int i = 0; i < limit; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < limit; j++) {
                switch (minerals[j]) {
                    case "diamond" -> dia++;
                    case "iron" -> iron++;
                    case "stone" -> stone++;
                }
            }
            groups.add(new Node(dia, iron, stone));
        }

        // 2. 중요도 높은 묶음 순으로 정렬
        Collections.sort(groups, (a, b) -> {
            if (b.dia != a.dia) return b.dia - a.dia;
            if (b.iron != a.iron) return b.iron - a.iron;
            return b.stone - a.stone;
        });

        // 3. 곡괭이 배정
        int answer = 0;
        for (int i = 0; i < groups.size(); i++) {
            Node cur = groups.get(i);
            if (picks[0] > 0) { // 다이아 곡괭이
                answer += cur.dia + cur.iron + cur.stone;
                picks[0]--;
            } else if (picks[1] > 0) { // 철 곡괭이
                answer += cur.dia * 5 + cur.iron + cur.stone;
                picks[1]--;
            } else if (picks[2] > 0) { // 돌 곡괭이
                answer += cur.dia * 25 + cur.iron * 5 + cur.stone;
                picks[2]--;
            } else break;
        }

        return answer;
    }
}
