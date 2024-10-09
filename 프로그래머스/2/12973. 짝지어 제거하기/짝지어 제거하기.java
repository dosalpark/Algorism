import java.util.Stack;

class Solution {

    public int solution(String s) {
        int answer = 1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if (stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }


        return stack.isEmpty() ? answer : 0;
    }
}
