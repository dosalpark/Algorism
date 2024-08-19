import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int count = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < queue1.length; i++){
            q1.add(queue1[i]);
            sum1 += queue1[i];
            q2.add(queue2[i]);
            sum2 += queue2[i];
            count += 2;
        }
        
        while(true){
            if(answer > count*3){
                answer = -1;
                break;
            }
            
            if(sum1 < sum2){
                int cur = q2.poll();
                q1.add(cur);
                sum2 -= cur;
                sum1 += cur;
                answer++;
            } else if(sum1 > sum2){
                int cur = q1.poll();
                q2.add(cur);
                sum1 -= cur;
                sum2 += cur;
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}