//정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
//
//제한 조건
//num은 int 범위의 정수입니다.
//0은 짝수입니다.
//
////start
//class Solution {
//    public String solution(int num) {
//        String answer = "";
//        //음수값이 들어오면 절대값으로 변환이 필요함.
//        num = Math.abs(num);
//        if(num%2==0){
//            answer="Even";
//        } else if (num%2==1){
//            answer="Odd";
//        }
//        return answer;
//    }
//}