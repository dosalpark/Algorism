import java.util.PriorityQueue;

class Solution {

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            if (k > 0) {
                pq.add(enemy[i]);
                k--;
            } else {
                int now = enemy[i];
                if (pq.peek() < enemy[i]) {
                    now = pq.poll();
                    pq.add(enemy[i]);
                }
                if (now > n) {
                    break;
                }
                n -= now;
            }
            answer++;
        }


        return answer;
    }
}
