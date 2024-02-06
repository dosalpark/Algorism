//어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
//예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다.
//"z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
//
////start
//class Solution {
//    public String solution(String s, int n) {
//        String answer = "";
//        //char배열로 변경
//        char[] sChar = s.toCharArray();
//        for(char c : sChar){
//            int i = (int)c;
//            //char가 소문자면
//            if(65 <= i&&i <= 90){
//                //n을 합쳐서 소문자범위가 지나면 미리 -26
//                if(i+n > 90){
//                    i -= 26;
//                }
//                i += n;
//                answer += (char)i;
//                //char가 대문자면
//            } else if (97 <= i&&i <= 122){
//                //n을 합쳐서 대문자범위가 지나면 미리 -26
//                if(i+n > 122){
//                    i -= 26;
//                }
//                i += n;
//                answer += (char)i;
//            } else {
//                //공백이면 그냥입력
//                answer += (char)i;
//            }
//        }
//        return answer;
//    }
//}