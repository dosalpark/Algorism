import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public int solution(int[][] jobs) {
        int answer = 0;
        int division = jobs.length;
        int time = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
        {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        for (int[] job : jobs) {
            pq.add(job);
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            Queue<int[]> queue = new LinkedList<>();
            while (!pq.isEmpty() && time >= pq.peek()[0]) {
                int[] next = pq.poll();
                if (cur[1] < next[1]) {
                    queue.add(next);
                } else {
                    queue.add(cur);
                    cur = next;
                }
            }
            pq.addAll(queue);
            if (time <= cur[0]) {
                time = cur[0] + cur[1];
                answer += cur[1];
            } else {
                time += cur[1];
                answer += time - cur[0];
            }

        }


        return answer / division;
    }
}
