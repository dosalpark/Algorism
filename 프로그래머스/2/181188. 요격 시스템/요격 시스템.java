
import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int a = 0;
        
    
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        for(int[] target : targets){            
            if(a <= target[0]){
                a = target[1];
                answer++;
                // System.out.println("answer: " + answer);  
            }        
            // System.out.println("[0]- " + target[0] + " / [1]- " + target[1]);
        }
        
        return answer;
    }
}