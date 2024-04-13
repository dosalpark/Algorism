import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        int sum = 0;
        for(int a : d){
            sum += a;
            if(sum <= budget){
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}