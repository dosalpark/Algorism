class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        answer = new_id.toLowerCase(); //"...!@bat#*..y.abcdefghijklm"
        answer = answer.replaceAll("[^0-9a-z-_.]", ""); //"...bat..y.abcdefghijklm"
        answer = answer.replaceAll("\\.+","."); //".bat.y.abcdefghijklm"
        answer = answer.replaceAll("^\\.", ""); //"bat.y.abcdefghijklm"
        answer = answer.replaceAll("\\.$", ""); //"bat.y.abcdefghijklm"
        
        if(answer.equals("")){
            answer = "a";
        }
        
        if(answer.length() > 15){
            answer = answer.substring(0,15);
            answer = answer.replaceAll("\\.$", "");
        }
        
        if(answer.length() < 3){
            char lastAnswerChar = answer.charAt(answer.length() -1);
            while (answer.length() < 3) {
                answer += lastAnswerChar;
            }
        }
        
        System.out.println(answer);
        return answer;
    }
}