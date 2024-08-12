class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int right = 0;
        int left = 0;

        for(int i = 0; i < s.length(); i++){
            char now = s.charAt(i);
            if(now == '('){
                right++;
            } else if(now ==')'){
                left++;
            }
            
            if(right < left){
                break;
            }
        }
        
        if(right != left){
            answer = false;
        }

        return answer;
    }
}