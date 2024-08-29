import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < commands.length; i++){
            pq.clear();
            int start = commands[i][0] -1;
            int end = commands[i][1] -1;
            int target = commands[i][2];
            
            for(int j = start; j <= end; j++){
                pq.add(array[j]);
            }
            int t = 0;
            for(int j = 0; j < target; j++){
                t = pq.poll();
            }
            
            answer[i] = t;
            
        }
        
        return answer;
    }
}