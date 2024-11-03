import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int solution(int[] topping) {
        Set<Integer> Lset = new HashSet<>();
        Map<Integer, Integer> RMap = new HashMap<>();
        int answer = 0;

        for (int t : topping) {
            RMap.put(t, RMap.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            Lset.add(t);
            RMap.put(t, RMap.get(t) - 1);

            if (RMap.get(t) == 0) {
                RMap.remove(t);
            }

            if (Lset.size() == RMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}