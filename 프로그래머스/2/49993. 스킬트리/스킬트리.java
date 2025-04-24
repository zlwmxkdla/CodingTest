import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String tree : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for(char c : tree.toCharArray()) {
                if(skill.indexOf(c) != -1) sb.append(c);
            }

            // 스킬트리로 만든 스킬 시퀀스가 선행 스킬(skill)의 prefix인지 확인
            if(skill.startsWith(sb.toString())) {
                answer++;
            }
        }

        return answer;
    }
}
