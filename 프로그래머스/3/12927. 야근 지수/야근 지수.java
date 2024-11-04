import java.util.Collections;
import java.util.Locale;
import java.util.PriorityQueue;

class Solution {

    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.add((long) work);
        }

        while (n-- > 0 && !pq.isEmpty()) {
            long cur = pq.poll();
            cur -= 1;
            if(cur != 0){
                pq.add(cur);
            }
        }

        if(pq.isEmpty()){
            return answer;
        } else {
            while (!pq.isEmpty()){
                long cur = pq.poll();
                answer += cur * cur;
            }
        }

        return answer;
    }
}
