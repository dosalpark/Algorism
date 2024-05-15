import java.util.*;
class Solution {
    public String solution(String number, int k) {

        int answerLength = number.length() - k;
        StringBuilder answer = new StringBuilder();
        int index = 0;

        for(int i = 0; i < answerLength; i++){
            char max = 0;
            for(int j = index; j <= i + k; j++){
                if(number.charAt(j) > max){
                    max = number.charAt(j);
                    index = j+1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}