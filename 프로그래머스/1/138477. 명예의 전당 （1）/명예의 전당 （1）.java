import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int min = 2001;
        
        for(int i = 0; i < score.length; i++){
            if(i < k){
                pq.add(score[i]);
            } else {
                pq.add(score[i]);
                pq.poll();
            }
            int cur = pq.poll();
            answer[i] = cur;
            pq.add(cur);
        }
        
        return answer;
    }
}