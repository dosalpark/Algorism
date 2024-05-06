import java.util.Stack;
class Solution {
    public int solution(int n) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        while(true){
            stack.add(n%3);
            n = n/3;
            
            if(n == 0){
                break;
            }
        }
        
        int size = stack.size();
        
        for (int i = 0; i < size; i++){
            answer += stack.pop() * (Math.pow(3,i));
        }

        return answer;
    }
}