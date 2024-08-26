import java.util.*;
import java.util.Map.Entry;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : tangerine){
            if(!map.containsKey(i)){
                map.put(i,0);
            }
            map.put(i,map.get(i) +1);
        }

        for (Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            int count = integerIntegerEntry.getValue();
            pq.add(count);
        }

        while (true){
            int i = pq.poll();
            answer++;
            if(k > i){
                k -= i;
            } else {
                break;
            }

        }

        return answer;
    }
}