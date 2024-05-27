import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        Set<String> set = new HashSet<>();
        char beforeLast = '0';
        
        for(int i = 1; i <= words.length; i++){
            int size = set.size();
            set.add(words[i-1]);
            
            if(size == set.size() || (beforeLast != words[i-1].charAt(0) && beforeLast != '0')){
                int round = i / n +1;
                int line = i % n;

                if(i % n == 0 ){
                    round -= 1;
                    line = n;
                }
                answer[0] = line;
                answer[1] = round;
                break;
            }
            beforeLast = words[i-1].charAt(words[i-1].length() -1);
        }
        

        return answer;
    }
}