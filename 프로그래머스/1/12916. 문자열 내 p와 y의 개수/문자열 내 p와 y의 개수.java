class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int chk = 0;
        
        s = s.toLowerCase();
        
        for(int i = 0; i < s.length(); i++){    
            if(s.charAt(i) == 'p'){
                chk += 1;
            } else if (s.charAt(i) == 'y'){
                chk -= 1;
            }
        }
        
        if(chk != 0){
            answer = false;
        }

        return answer;
    }
}