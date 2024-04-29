import java.util.Stack;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        Stack<String> cards1Stack = new Stack<>();
        Stack<String> cards2Stack = new Stack<>();
        for (int i = cards1.length-1; i >=0; i--){
            cards1Stack.push(cards1[i]);
        }
        for (int i = cards2.length-1; i >=0; i--){
            cards2Stack.push(cards2[i]);
        }

        for (String s : goal) {
            boolean[] isEmpty = {true, true};
            if(!cards1Stack.isEmpty() && cards1Stack.peek().equals(s)){
                isEmpty[0] = false;
                cards1Stack.pop();
            } else if (!cards2Stack.isEmpty() && cards2Stack.peek().equals(s)){
                isEmpty[1] = false;
                cards2Stack.pop();
            }
            if(isEmpty[0] && isEmpty[1]){
                return answer;
            }
        }
        answer = "Yes";
        return answer;
    }
}