import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class Solution {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            que.add(entry.getValue());
        }

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (k <= 0) {
                break;
            }
            answer++;
            k -= cur;


        }
        return answer;
    }
}
