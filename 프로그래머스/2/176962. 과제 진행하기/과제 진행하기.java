import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<String> stack = new Stack<>();
        List<String> answerList = new ArrayList<>();

        // 정렬 (시간순으로)
        Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));

        for (int i = 0; i < plans.length - 1; i++) {
            String[] now = plans[i];
            int nowTime = Integer.parseInt(now[1].split(":")[0]) * 60 + Integer.parseInt(now[1].split(":")[1]) + Integer.parseInt(now[2]);
            String[] next = plans[i + 1];
            int nextTime = Integer.parseInt(next[1].split(":")[0]) * 60 + Integer.parseInt(next[1].split(":")[1]);
            int time = nextTime - nowTime;

            // 시간내에 끝내면
            if (time >= 0) {
                answerList.add(now[0]);
                while (!stack.isEmpty()) {
                    String open = stack.pop();
                    String sub = open.split(" ")[0];
                    int runtime = Integer.parseInt(open.split(" ")[1]);

                    if (time - runtime >= 0) {
                        answerList.add(sub);
                        time -= runtime;
                    } else {
                        stack.push(sub + " " + (runtime - time));
                        break;
                    }
                }
            } else {
                stack.push(now[0] + " " + (-time));
            }
        }

        // 마지막 계획 추가
        answerList.add(plans[plans.length - 1][0]);

        // 남은 스택 처리
        while (!stack.isEmpty()) {
            String open = stack.pop();
            String sub = open.split(" ")[0];
            answerList.add(sub);
        }

        // List를 배열로 변환
        answer = answerList.toArray(new String[0]);
        return answer;
    }
}
