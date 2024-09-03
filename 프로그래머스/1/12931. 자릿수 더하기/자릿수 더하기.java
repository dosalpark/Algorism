import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String nStr = String.valueOf(n);

        for(int i = 0; i < nStr.length(); i++){
            answer += nStr.charAt(i) - '0';
        }

        return answer;
    }
}