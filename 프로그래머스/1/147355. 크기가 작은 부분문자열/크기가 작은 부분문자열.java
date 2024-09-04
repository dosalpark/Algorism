class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long compare = Long.parseLong(p);
        
        for(int i = 0; i <= t.length() - p.length(); i++){
            long now = Long.parseLong(t.substring(i,i+p.length()));
            if(now <= compare){
                answer++;
            }
        }
        
        return answer;
    }
}