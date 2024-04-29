class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int count = 1;
        int stack = 0;
        for (int i = 0; i < attacks.length; i++) {
            if (attacks[i][0] == count) {
                //때리기
                health -= attacks[i][1];
                stack = 0;
                count++;
                if (health <= 0) {
                    return -1;
                }
            } else {
                //회복
                health += bandage[1];
                stack++;
                i--;
                count++;
                if (stack == bandage[0]) {
                    health += bandage[2];
                    stack = 0;
                }
                if(health>maxHealth){
                    health = maxHealth;
                }
            }
        }
        return health;
    }
}