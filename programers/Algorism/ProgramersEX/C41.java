//문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
//
//제한 사항
//문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
//첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
//
////start
//class Solution {
//    public String solution (String s) {
//        String answer = "";
//        char[] sChar = s.toCharArray();
//        int j = 0;
//        //s의 길이만큼 실행
//        for (int i = 0; i < sChar.length; i++){
//            //공백이 아닐 경우 짝수 대문자 홀수 소문자
//            if(sChar[i] != ' '){
//                if(j % 2 == 0) {
//                    sChar[i] = Character.toUpperCase(sChar[i]);
//                    j++;
//                } else if(j % 2 == 1) {
//                    sChar[i] = Character.toLowerCase(sChar[i]);
//                    j++;
//                }
//                //공백일 경우 0 초기화
//            } else {
//                j = 0;
//            }
//            //공백이든 짝수든 홀수든 나온것 넣음
//            answer += sChar[i];
//        }
//        return answer;
//    }
//}