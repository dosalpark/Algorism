class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for(int i = 0; i <= t.length()-p.length(); i++){
            String vsP = t.substring(i,p.length()+i);
            if(Long.parseLong(p) >= Long.parseLong(vsP)){
                answer++;
            }
        }
        return answer;
    }
}
    

