import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public long solution(long n) {
        String[] nStr = String.valueOf(n).split("");
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (String s : nStr) {
            pq.add(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            sb.append(pq.poll());
        }

        return Long.parseLong(sb.toString());
    }
}
