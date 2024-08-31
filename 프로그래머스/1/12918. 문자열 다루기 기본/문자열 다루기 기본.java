class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(!checkLength(s) || !checkInt(s)){
            answer = false;
        }
        return answer;
    }
    
    private boolean checkLength(String s){
        int len = s.length();
        return len == 4 || len == 6;
    }
    
    private boolean checkInt(String s){
        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            if(ch < '0' || '9' < ch){
                return false;
            }
        }
        return true;
    }
}