class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9-_.]","");
        answer = answer.replaceAll("[.]{2,}","."); 
        answer = answer.replaceAll("^[.]|[.]$","");
        answer = answer.isEmpty() ? "a" : answer;
        answer = answer.length() >= 16 ? answer.substring(0,15) : answer;
        answer = answer.replaceAll("[.]$","");
        
        if(answer.length() < 3){
            char last = answer.charAt(answer.length()-1);
            while(answer.length() < 3){
                answer += last;
            }
        }
        
        return answer;
    }
}