//문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
//예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
//
////start
//class Solution {
//    public boolean solution(String s) {
//        boolean answer = true;
//        char[] sChar = s.toCharArray();
//        if(!(s.length() == 4 || s.length() == 6)){
//            return answer = false;
//        }
//        //sChar에 영어가 들어있는지 확인
//        for(int i = 0; i < sChar.length; i++){
//            //ascii 코드 숫자범위 넘어가면
//            if(sChar[i] > 57){
//                return answer = false;
//            }
//        }
//
//        return answer;
//    }
//}