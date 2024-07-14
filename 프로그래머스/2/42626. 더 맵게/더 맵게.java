import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for(int i : scoville){
            pq.offer(i);
        }
        
        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(cur < K && !pq.isEmpty()){
                answer++;
                int next = pq.poll();
                int sum = cur + next*2;
                    pq.offer(sum);
            }
            if(cur >= K){
                list.add(cur);
            }
        }
        if(list.isEmpty()){
            answer = -1;
        }
        
        return answer;
    }
}