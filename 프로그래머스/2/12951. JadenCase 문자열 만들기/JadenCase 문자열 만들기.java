import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        s = s.toLowerCase();
        String[] sArr = s.split(" ");

        int end = 0;

        for(int i = s.length() -1; i >= 0; i--){
            if(s.charAt(i) != ' ') {
                break;
            }
            end++;
        }

        for(int i = 0; i < sArr.length; i++){
            if(sArr[i].length() == 0) {
                answer.append(" ");
                continue;
            }

            if('0' <= sArr[i].charAt(0) && sArr[i].charAt(0) <= '9'){
                answer.append(sArr[i]);
            } else {
                String first = String.valueOf(sArr[i].charAt(0)).toUpperCase();
                answer.append(first);
                if(sArr[i].length() > 1){
                    String etc = sArr[i].substring(1);
                    answer.append(etc);
                }
            }
            if(i != sArr.length -1){
                answer.append(" ");
            }

        }

        for(int i = 0; i < end; i++){
            answer.append(" ");
        }

        return answer.toString();
    }
}
