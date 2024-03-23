import java.util.*;
class Solution {
    public int solution(int[] order){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int orderSize = order.length;
        int index = 0;
        for(int i = 1; i <= order.length; i++){
            if(i != order[index]){
                stack.push(i);
            } else {
                answer++;
                index++;
            }
            while(!stack.isEmpty() && stack.peek() == order[index]){
                stack.pop();
                index++;
                answer++;
            }
        }
        return answer;
    }
}