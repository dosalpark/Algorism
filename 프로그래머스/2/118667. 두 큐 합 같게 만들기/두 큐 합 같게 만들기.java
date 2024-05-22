import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int maxCount = queue1.length * 3;
        long que1Sum = 0L;
        long que2Sum = 0L;
        Queue<Long> que1 = new LinkedList<>();
        Queue<Long> que2 = new LinkedList<>();
        
        for(int i = 0; i < queue1.length; i++){
            que1Sum += queue1[i];
            que1.offer(queue1[i]+0L);
            que2Sum += queue2[i];
            que2.offer(queue2[i]+0L);
        }
        
        
        long total = que1Sum + que2Sum;
        long half = total/2;
        
        if(total%2 == 1){
            return -1;
        }
        
        while(que1Sum != half){
            if(que1Sum > que2Sum){
                long cur = que1.poll();
                if(cur > half) return -1;
                que1Sum -= cur;
                que2Sum += cur;
                que2.offer(cur);
                
            } else {
                long cur = que2.poll();
                if(cur > half) return -1;
                que2Sum -= cur;
                que1Sum += cur;
                que1.offer(cur);
            }
            
            answer++;
            maxCount--;
            if(maxCount < 0) return -1;
        }
        
        return answer;
    }
}