import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        List<String> bracket = new ArrayList<>();
        bracket.add("{}");
        bracket.add("()");
        bracket.add("[]");

        for(int i = 0; i < s.length(); i++){
            String left = s.substring(i) + s.substring(0,i);
            Stack<Character> stack = new Stack<>();

            stack.push(left.charAt(0));

            for (int j = 1; j < left.length(); j++){
                if(stack.isEmpty()){
                    stack.push(left.charAt(j));
                } else {
                    String check = String.valueOf(stack.peek()) + left.charAt(j)+"";
                    if(bracket.contains(check)) {
                        stack.pop();
                    } else {
                        stack.push(left.charAt(j));
                    }
                }
            }
            if(stack.isEmpty()){
                answer++;
            }
        }

        return answer;
    }
}
