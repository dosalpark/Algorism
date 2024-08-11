import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());


        for (String oper : operations) {
            String type = oper.split(" ")[0];
            int value = Integer.parseInt(oper.split(" ")[1]);
            switch (type) {
                case "I":
                    pq.add(value);
                    rpq.add(value);
                    break;
                case "D":
                    if (pq.isEmpty() && rpq.isEmpty()) {
                        break;
                    }
                    if (value == -1) {
                        rpq.remove(pq.poll());
                    } else {
                        pq.remove(rpq.poll());

                    }
                    break;
            }
        }
        if (!pq.isEmpty() && !rpq.isEmpty()) {
            answer[0] = rpq.poll();
            answer[1] = pq.poll();
        }

        return answer;
    }
}
