class Solution {
    public String solution (String s) {
        String answer = "";
        char[] sChar = s.toCharArray();
        int j = 0;
        //s의 길이만큼 실행
        for (int i = 0; i < sChar.length; i++){
            //공백이 아닐 경우 짝수 대문자 홀수 소문자
            if(sChar[i] != ' '){
                if(j % 2 == 0) {
                    sChar[i] = Character.toUpperCase(sChar[i]);
                    j++;
                } else if(j % 2 == 1) {
                    sChar[i] = Character.toLowerCase(sChar[i]);
                    j++;
                }
            //공백일 경우 0 초기화
            } else {
                j = 0;   
            }
        //공백이든 짝수든 홀수든 나온것 넣음
        answer += sChar[i];
        }
        return answer;
    }
}