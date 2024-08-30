class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        
        s = s.toUpperCase();
        for(int i = 0; i < s.length(); i++){
            String now = String.valueOf(s.charAt(i));
            if(now.equals("P")){
                p++;
                continue;        
            } else if(now.equals("Y")){
                y++;    
            }
        }
        
        return p == y;
    }
}