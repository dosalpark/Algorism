import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < weights.length; i++) {
            double de = weights[i] * 1.0;
            double a = weights[i] * 2.0 / 3;
            double b = weights[i] * 3.0 / 4;
            double c = weights[i] / 2.0;
            if (map.containsKey(de)) {
                answer += map.get(de);
            }
            if (map.containsKey(a)) {
                answer += map.get(a);
            }
            if (map.containsKey(b)) {
                answer += map.get(b);
            }
            if (map.containsKey(c)) {
                answer += map.get(c);
            }
            map.put(de, map.getOrDefault(de, 0) + 1);
        }

        return answer;
    }
}
