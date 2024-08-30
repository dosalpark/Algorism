import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<String, Integer> map = new HashMap<>();

        for (String line : keymap) {
            int len = line.length();
            for (int i = 0; i < len; i++) {
                String ch = String.valueOf(line.charAt(i));
                if (map.containsKey(ch)) {
                    if (map.get(ch) > i + 1) {
                        map.put(ch, i + 1);
                    }
                } else {
                    map.put(ch, i + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                String ch = String.valueOf(targets[i].charAt(j));
                if (map.containsKey(ch)) {
                    sum += map.get(ch);
                } else {
                    sum = -1;
                    break;
                }
            }

            answer[i] = sum;
        }



        return answer;
    }
}
