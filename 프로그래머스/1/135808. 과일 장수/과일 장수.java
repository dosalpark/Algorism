import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int count = 0;
        
        Arrays.sort(score);
        
        
        for(int i = score.length -1; i >= 0; i--){
            count++;
            if(count == m){
                answer += score[i] * m;
                count = 0;
            }
        }
        
        return answer;
    }
}