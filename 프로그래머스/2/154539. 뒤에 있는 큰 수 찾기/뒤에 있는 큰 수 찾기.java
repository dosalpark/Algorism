import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }

            if (!stack.empty()) {
                answer[i] = stack.peek();
            }
            stack.add(numbers[i]);
        }
        
        return answer;
    }
}