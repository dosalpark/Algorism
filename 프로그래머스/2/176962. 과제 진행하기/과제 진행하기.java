import java.util.Arrays;
import java.util.Stack;

class Solution {

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<String> stack = new Stack<>();
        int answerIndex = 0;
        Arrays.sort(plans, (o1, o2) -> {
            int a = (Integer.parseInt(o1[1].split(":")[0]) * 60) + Integer.parseInt(
                o1[1].split(":")[1]);
            int b = (Integer.parseInt(o2[1].split(":")[0]) * 60) + Integer.parseInt(
                o2[1].split(":")[1]);
            return a - b;
        });

        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int nowTime = converter(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);

            if (i == plans.length - 1) {
                answer[answerIndex] = name;
                answerIndex++;
            } else {
                int remainTime = converter(plans[i + 1][1]) - (nowTime + playTime);
                if (remainTime >= 0) {
                    answer[answerIndex] = name;
                    answerIndex++;

                    while (!stack.isEmpty() && remainTime >= 0) {
                        String cur = stack.pop();
                        String remainName = cur.split(" ")[0];
                        int remainPlayTime = Integer.parseInt(cur.split(" ")[1]);
                        remainTime -= remainPlayTime;
                        if (remainTime >= 0) {
                            answer[answerIndex] = remainName;
                            answerIndex++;
                        } else {
                            stack.push(remainName + " " + Math.abs(remainTime));
                        }
                    }
                } else {
                    stack.push(name + " " + Math.abs(remainTime));
                }
            }
        }

        while (!stack.isEmpty()){
            answer[answerIndex] = stack.pop().split(" ")[0];
            answerIndex++;
        }

        return answer;
    }

    private int converter(String startTime) {
        return Integer.parseInt(startTime.split(":")[0]) * 60
            + Integer.parseInt(startTime.split(":")[1]);

    }
}
