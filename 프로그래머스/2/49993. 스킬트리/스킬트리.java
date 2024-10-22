class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            if (check(skill, skill_tree)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean check(String skill, String skillTree) {

        while (!skill.isEmpty() && !skillTree.isEmpty()) {
            char ch = skillTree.charAt(0);
            int turn = skill.indexOf(ch);
            if (turn == -1) {
                skillTree = skillTree.substring(1);
            } else if (turn > 0) {
                return false;
            } else {
                skillTree = skillTree.substring(1);
                skill = skill.substring(1);
            }
        }

        return true;

    }
}
