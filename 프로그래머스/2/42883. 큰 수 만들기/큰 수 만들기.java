import java.util.Arrays;
import java.util.Stack;

class Solution {

    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] numbers = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while ( !stack.isEmpty() && stack.peek() < numbers[i] && k > 0) {
                stack.pop();
                k--;
            }
            stack.add(numbers[i]);
        }
        for (Integer integer : stack) {
            sb.append(integer);
        }
        if(k != 0){
            answer = sb.substring(0, sb.length() - k);
        } else {
            answer = sb.toString();
        }

        return answer;
    }
}
