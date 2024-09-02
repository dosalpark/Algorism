class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                sb.append(" ");
                continue;
            } else {
                char first = 'a';
                char last = 'z';
                if(ch < first){
                    first = 'A';
                    last = 'Z';
                }
                
                for(int j = 0; j < n; j++){
                    ch +=1;
                    if(ch > last){
                        ch = first;
                    }
                }
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}