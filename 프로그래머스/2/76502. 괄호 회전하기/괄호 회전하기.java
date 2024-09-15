import java.util.*;

class Solution {

    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        s = s + s;
        for (int i = 0; i < len; i++) {
            String changeS = s.substring(i, len + i);
            if (check(changeS)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean check(String changeS) {
        Stack<String> stack = new Stack<>();
        for (int j = 0; j < changeS.length(); j++) {
            String now = String.valueOf(changeS.charAt(j));
            if (now.equals("(") || now.equals("{") || now.equals("[")) {
                stack.add(now);
            } else {
                String partner = "";
                if (now.equals(")")) {
                    partner = "(";
                }
                if (now.equals("}")) {
                    partner = "{";
                }
                if (now.equals("]")) {
                    partner = "[";
                }

                if (stack.isEmpty() || !stack.peek().equals(partner)) {
                    return false;
                }
                stack.pop();
            }

        }
        return stack.isEmpty();
    }
}