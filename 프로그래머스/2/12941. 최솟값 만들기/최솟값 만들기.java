import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < A.length; i++){
            pq.offer(A[i]);
            rpq.offer(B[i]);
        }
        
        while(!pq.isEmpty()){
            answer += pq.poll() * rpq.poll();
        }

        return answer;
    }
}