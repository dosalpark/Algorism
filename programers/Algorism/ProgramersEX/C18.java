//문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
//
//제한 조건
//s의 길이는 1 이상 5이하입니다.
//s의 맨앞에는 부호(+, -)가 올 수 있습니다.
//s는 부호와 숫자로만 이루어져있습니다.
//s는 "0"으로 시작하지 않습니다.
//
////start
//class Solution {
//    public int solution(String s) {
//        int answer = 0;
//        int sum = 0;
//        boolean minuscheck = false;
//        //s의 자릿수 확인
//        int length = s.length();
//        //자릿수만큼 반복
//        for (int i = 0; i < length; i++){
//            if(s.charAt(i) == '-'){
//                //음수일때 false로 변경해서 마지막에 * -1
//                minuscheck = true;
//            }else if(s.charAt(i) == '+'){
//                //+ 붙을때는 그냥 진행
//                continue;
//            }
//            else {
//                sum = (sum*10) + (s.charAt(i) - 48);
//            }
//        }
//        if (minuscheck==true){
//            sum = sum * -1;
//        }
//        answer = sum;
//        return answer;
//        // 계산하다가 String변환하는 메소드로 적용했더니 통과...
//        // return answer = Integer.parseInt(s);
//
//    }
//}
continu;