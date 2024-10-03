import java.util.HashMap;
import java.util.Map;

class Solution {

    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        for (int i = 0; i < Math.max(X.length(), Y.length()); i++) {
            if (X.length() > i) {
                xMap.put(X.charAt(i) - '0', xMap.getOrDefault(X.charAt(i) - '0', 0) + 1);
            }
            if (Y.length() > i) {
                yMap.put(Y.charAt(i) - '0', yMap.getOrDefault(Y.charAt(i) - '0', 0) + 1);
            }
        }

        for (int i = 9; i >= 0; i--) {
            int size = Math.min(xMap.getOrDefault(i, 0), yMap.getOrDefault(i, 0));
            for (int j = 0; j < size; j++) {
                answer.append(i);
            }
        }
        if (answer.length() == 0) {
            answer.append("-1");
        } else if (answer.toString().charAt(0) == '0') {
            answer.setLength(0);
            answer.append("0");
        }
        
        return answer.toString();
    }
}
