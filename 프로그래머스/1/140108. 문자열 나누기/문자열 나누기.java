import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int ECount = 1;
        int NECount = 0;
        char start = s.charAt(0);
        
        for(int i = 1; i < s.length(); i++){
            if(ECount==0){
                start = s.charAt(i);
                ECount++;
                continue;
            }
            
            if(start == s.charAt(i)){
                ECount++;
            }else{
                NECount++;
            }
            
            if(ECount == NECount){
                answer++;
                ECount = 0;
                NECount = 0;
            }
        }
        if(ECount > NECount){
            answer++;
        }
        
        return answer;
    }
}