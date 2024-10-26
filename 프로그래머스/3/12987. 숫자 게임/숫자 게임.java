import java.util.PriorityQueue;

class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            pqA.add(A[i]);
            pqB.add(B[i]);
        }

        while (!pqB.isEmpty()) {
            if (pqA.peek() < pqB.peek()) {
                answer++;
                pqA.poll();
            }
            pqB.poll();
        }
        return answer;
    }
}