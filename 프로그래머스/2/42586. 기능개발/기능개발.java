import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        StringBuilder answerStr = new StringBuilder();
        int[] makeProgresses = new int[progresses.length];

        for (int i = 0; i < makeProgresses.length; i++){
            makeProgresses[i] = (int) Math.ceil((100 - progresses[i]) / (float)speeds[i]);
        }
        //기준점
        int n = 0;
        int sum = 0;
        for (int i = 0; i < makeProgresses.length; i++){
            if(makeProgresses[n] >= makeProgresses[i]){
                sum++;
            } else if(makeProgresses[n] < makeProgresses[i]){
                answerStr.append(sum);
                answerStr.append(",");
                sum = 0;
                sum++;
                n = i;
            }
        }
        answerStr.append(sum);
        int[] answer = Arrays.stream(answerStr.toString().split(",")).mapToInt(i -> Integer.parseInt(i)).toArray();

        return answer;
    }
}