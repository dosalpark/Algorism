import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++){
            que.add(scoville[i]);
        }
        
        while(!que.isEmpty()){
            int cur = que.poll();
            
            if(cur >= K ){
                return answer;
            } else {
                if(!que.isEmpty()){
                    int second = que.poll();
                    int sum = cur + second *2;
                
                    que.add(sum);
                    answer++;    
                } else {
                    answer = -1;
                }
                
            }
        }
        
        return answer;
    }
}