import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                if(stack.peek().equals(String.valueOf(s.charAt(i)))){
                    stack.pop();
                } else {
                    stack.push(String.valueOf(s.charAt(i)));
                }
            }
        }
        if(stack.isEmpty()){
            answer = 1;
        }
    
        return answer;
    }
}