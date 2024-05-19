class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            boolean flag = true;
            int index = 0;
            for (int i = 0; i < tree.length(); i++) {
                if(skill.indexOf(tree.charAt(i)) == -1){
                    continue;
                }

                if(skill.charAt(index) == tree.charAt(i)){
                    index++;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
        }
        return answer;
    }
}
