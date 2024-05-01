import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int stack = 0;
        Map<Integer, Integer> scoreMap = new HashMap<>();
        for (int i = 1; i <= k; i++){
            scoreMap.put(i,0);
        }
        for (int i = 0; i < score.length; i++) {
            scoreMap.put(score[i], scoreMap.getOrDefault(score[i], 0) + 1);
        }

        for (int i = k; i > 0; i--){
            stack += scoreMap.get(i);
            if(stack >= m){
                int boxs = stack / m;
                stack = stack % m;
                answer +=  (boxs * i * m);
            }
        }
        return answer;
    }
}