//자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
//
//제한 조건
//n은 10,000,000,000이하인 자연수입니다.
//
////start
//class Solution {
//    public long[] solution(long n) {
//        long[] answer = {};
//        //자릿수구하기위 해 check에 n값 넣어서 자릿수체크
//        int j = 0;
//        long check;
//        check = n;
//        while(check > 0){
//            check = check / 10;
//            j++;
//        }
//        //자릿수만큼 배열 자리생성
//        answer = new long[j];
//
//        //값 대입
//        for (int i = 0; i < j; i++) {
//            answer[i] = n % 10;
//            n = n / 10;
//        }
//        return answer;
//    }
//}