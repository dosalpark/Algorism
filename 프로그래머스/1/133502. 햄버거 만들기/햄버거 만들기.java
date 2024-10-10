import java.util.Stack;

class Solution {

    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        boolean bread = false;
        boolean vegetable = false;
        boolean meat = false;
        stack.push(0);
        for (int i = 0; i < ingredient.length; i++) {
            int now = ingredient[i];
            if (now == 1 & bread && vegetable && meat) {
                answer++;
                for (int j = 0; j < 3; j++) {
                    stack.pop();
                }
                bread = false;
                vegetable = false;
                meat = false;

                if (stack.peek() == 2) {
                    int cur = stack.pop();
                    if (stack.peek() == 1) {
                        bread = true;
                        vegetable = true;
                    }
                    stack.push(cur);
                } else if (stack.peek() == 1) {
                    bread = true;
                }
                continue;
            }

            if (now == 1) {
                bread = true;
                vegetable = false;
                meat = false;
            }

            if (now == 2) {
                if (stack.peek() == 1) {
                    vegetable = true;
                } else {
                    bread = false;
                }
            }
            if (now == 3) {
                if (bread && vegetable && stack.peek() == 2) {
                    meat = true;
                } else {
                    bread = false;
                    vegetable = false;
                }
            }
            stack.push(now);
        }

        return answer;
    }
}
