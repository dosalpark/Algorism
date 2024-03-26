import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ");
        int[] sInt = Arrays.stream(sArr).mapToInt(Integer::parseInt).toArray();

        int max = sInt[0];
        int min = sInt[0];

        for (int i = 1; i < sInt.length; i++){
            if (sInt[i] > max){
                max = sInt[i];
            } else if(sInt[i] < min){
                min = sInt[i];
            }
        }
        answer = min +" "+max;
        return answer;
    }
}